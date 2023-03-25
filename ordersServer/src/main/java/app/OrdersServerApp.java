package app;

import controller.DBController;
import controller.PacketController;
import controller.SocketController;
import domain.Packet;
import domain.ProtocolCodes;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class OrdersServerApp {

    private final Map<Long, Thread> connections = new HashMap<>();
    private final DBController dbController = new DBController();
    private final PacketController packetController = new PacketController();
    private final SocketController socketController = new SocketController();

    public void run() {
        new Thread(new ClientManager()).start();

        System.out.println("\nInitialized Order Server.\nWaiting for new connections.");
    }

    public void removeConnection(long connectionID) {
        connections.remove(connectionID);
    }

    private class ClientManager implements Runnable {

        private final String jks = "/Users/ruigoncalves/Desktop/sem_pi_4/lei21_22_s4_2dk_03/ordersServer/src/main/resources/serverKeyStore.jks";

        @Override
        public void run() {
            System.setProperty("javax.net.ssl.keyStore", jks);
            System.setProperty("javax.net.ssl.keyStorePassword", "password");

            SSLServerSocket ss = socketController.createServerSocket(2225);

            while (true) {
                try {
                    SSLSocket clientSocket = (SSLSocket) ss.accept();
                    Thread newThread = new Thread(new TcpThread(clientSocket));

                    connections.put(newThread.getId(), newThread);
                    connections.get(newThread.getId()).start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private class TcpThread implements Runnable {

        private final SSLSocket socket;
        private ObjectOutputStream output;
        private ObjectInputStream input;
        private Connection dbConnection;

        public TcpThread(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String customerID = null;
            System.out.println("\nNew client connection - " + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());

            if (!performSetup()) {
                removeConnection(Thread.currentThread().getId());
                System.out.println("Closed");
                return;
            }

            while (true) {
                Packet packet = packetController.receivePacket(input);

                if (packet == null) {
                    removeConnection(Thread.currentThread().getId());
                    return;
                }
                if (packet.getCode() == ProtocolCodes.JOB_LOGIN.getCodeKey()) {
                    String email = new String(packet.getData(), StandardCharsets.UTF_8);
                    System.out.println("Packet Received -> Email: " + email);
                    customerID = getCustomerID(email);
                    packetController.sendPacket(ProtocolCodes.JOB_LOGIN.getCodeKey(), customerID.getBytes(), output);
                }
                if (packet.getCode() == ProtocolCodes.JOB_ORDER_CHECK_STATUS.getCodeKey()) {
                    String id = new String(packet.getData(), StandardCharsets.UTF_8);
                    System.out.println("Packet Received -> ID: - " + id);
                    String msg = statusOpen(id);
                    packetController.sendPacket(ProtocolCodes.JOB_ORDER_CHECK_STATUS.getCodeKey(), msg.getBytes(), output);
                }
                if (packet.getCode() == ProtocolCodes.JOB_PRODUCT_OPTION.getCodeKey()) {
                    //String id = new String(packet.getData(), StandardCharsets.UTF_8);
                    System.out.println("Packet Received ..");
                    String prods = listProducts();
                    packetController.sendPacket(ProtocolCodes.JOB_PRODUCT_OPTION.getCodeKey(), prods.getBytes(), output);
                }
                if(packet.getCode() == ProtocolCodes.JOB_ADD_PRODUCT.getCodeKey()) {
                    String idProd = new String(packet.getData(), StandardCharsets.UTF_8);
                    System.out.println("Packet Received ..");

                    String choose = productOption("28", idProd);
                    String insert = productInsert("28");
                    packetController.sendPacket(ProtocolCodes.JOB_ADD_PRODUCT.getCodeKey(), choose.getBytes(), output);
                    packetController.sendPacket(ProtocolCodes.JOB_ADD_PRODUCT.getCodeKey(), insert.getBytes(), output);
                }
            }
        }
        private boolean performSetup() {
            try {
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());

                try {
                    dbConnection = dbController.createConnection();
                    return true;
                } catch (Exception e) {
                    System.err.println("Failed to connect to the database: " + e);
                }
            } catch (IOException e) {
                System.err.println("Failed to create I/O streams: " + e);
            }
            return false;
        }
        private String productOption(String idCust, String idProd) {
            return dbController.executeUpdateQuery(
                    "INSERT INTO NEWORDER_ITEMORDERED(NEWORDER_ORDERID, ITEMORDEREDS_ITEMORDEREDID) VALUES ('" + idCust + "', '" + idProd + "')");
        }
        private String productInsert(String idCust) {
            String calendar = String.valueOf(LocalDateTime.now());
            return dbController.executeUpdateQuery("INSERT INTO NEWORDER (ORDERID, ROLE, DATE, PAYMENT_METHOD, PRICE, SHIPMENT, STATUS, CUSTOMER_PK) VALUES ('6', '0', '" + calendar + "', 'CREDIT_CARD', '3.29', 'STANDARD', 'REGISTERED', '" + idCust + "')");
        }
        private String listProducts() {
            return dbController.executeQuery("SELECT * FROM PRODUCT", dbConnection, "product");
        }
        private String getCustomerID(String email) {
            return dbController.executeQuery("SELECT PK FROM CUSTOMER WHERE EMAIL = '" + email + "'", dbConnection, "login");
        }

        private String statusOpen(String message) {
            return dbController.executeQuery("SELECT * FROM NEWORDER WHERE STATUS IS NOT 'DELIVERED' AND CUSTOMER_PK = " + message, dbConnection, "order");
        }
    }
}
