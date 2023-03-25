package ui;

import controller.PacketController;
import controller.SocketController;
import domain.Packet;
import domain.ProtocolCodes;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class customerAppUI {
    private static final String JOB_ORDER = "orderStatus";
    private static final String DO_LOGIN = "login";
    private static final String JOB_CHOOSE_PRODUCT = "productOption";
    private static final String JOB_ADD_PRODUCT = "addOrders";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static String ANSI_RESET = "\033[0m";

    public static String customerID;

    public void mainMenu() {


        int choice;
            do {
                String[] options = {"Exit\n", "Do Login", "Check your Open Orders status", "Add Products to ShopCart\n"};
                printFrontMenu("Main Menu", options, true);
                choice = readInt("Please make a selection: ");
                switch (choice) {
                    case 0:
                        break;

                    case 1:
                        String email = readString("Email: ");
                        new CustomerApp().run(email, DO_LOGIN, null);
                        break;

                    case 2:
                        new CustomerApp().run(customerID, JOB_ORDER, null);
                        break;

                    case 3:
                        new CustomerApp().run(customerID, JOB_CHOOSE_PRODUCT, null);
                        String option = String.valueOf(readInt("Please select a product: " + "\n" + ANSI_CYAN + "Note: Please select the ID of the product\n" + ANSI_RESET + "> "));

                        new CustomerApp().run(option, JOB_ADD_PRODUCT, customerID);
                        break;

                    default:
                        System.out.println("Invalid Option!");
                        break;
                }

            } while (choice != 0);
    }

    private static void printFrontMenu(String title, String[] options, boolean showExit) {
        System.out.println(
                "\n+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+\n" +
                        "           Customer APP > " + title +
                        "\n+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");

        for (int i = 0; i < options.length; i++) {
            if (i == 0 && showExit || i > 0) {
                System.out.println("  " + i + " > " + options[i]);
            }
        }
    }

    public static int readInt(String msg) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(msg);
            String str = sc.nextLine();
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        } while (true);
    }

    public static String readString(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextLine();
    }

    public class CustomerApp {

        private SSLSocket socket;
        private ObjectOutputStream output;
        private ObjectInputStream input;
        private final SocketController socketController = new SocketController();
        private final PacketController packetController = new PacketController();
        private static final String SERVER_IP = "0.0.0.0";
        private static final String jts = "/Users/ruigoncalves/Desktop/sem_pi_4/lei21_22_s4_2dk_03/ordersServer/src/main/resources/clientTrustStore.jks";

        public void run(String message, String job, String custID) {
            if(!performSetup(message, job, custID)) return;
            Packet packet = packetController.receivePacket(input);

            if (packet.getCode() == ProtocolCodes.JOB_ORDER_CHECK_STATUS.getCodeKey()) {
                System.out.println(new String(packet.getData(), StandardCharsets.UTF_8));
            } else if (packet.getCode() == ProtocolCodes.JOB_LOGIN.getCodeKey()) {
                customerID = new String(packet.getData(), StandardCharsets.UTF_8);
            } else if (packet.getCode() == ProtocolCodes.JOB_PRODUCT_OPTION.getCodeKey()) {
                System.out.println(new String(packet.getData(), StandardCharsets.UTF_8));
            }
        }

        private boolean performSetup(String message, String job, String custID) {
            System.setProperty("javax.net.ssl.trustStore", jts);
            System.setProperty("javax.net.ssl.trustStorePassword", "password");

            try {
                InetAddress serverIP = InetAddress.getByName(SERVER_IP);
                socket = socketController.createSocketClient(serverIP, 2225); //10753 // 2223

                try {
                    output = new ObjectOutputStream(socket.getOutputStream());
                    input = new ObjectInputStream(socket.getInputStream());
                    try {
                        switch (job) {
                            case "orderStatus":
                                packetController.sendPacket(ProtocolCodes.JOB_ORDER_CHECK_STATUS.getCodeKey(), message.getBytes(), output);
                                break;
                            case "login":
                                packetController.sendPacket(ProtocolCodes.JOB_LOGIN.getCodeKey(), message.getBytes(), output);
                                break;
                            case "productOption":
                                packetController.sendPacket(ProtocolCodes.JOB_PRODUCT_OPTION.getCodeKey(), message.getBytes(), output);
                                break;
                            case "addOrders":
                                packetController.sendPacket(ProtocolCodes.JOB_ADD_PRODUCT.getCodeKey(), message.getBytes(), output);
                                break;
                            default:
                                System.out.println("Invalid Job Name.");
                                break;
                        }
                        return true;
                    } catch (Exception e) {
                        System.err.println("Failed to assign the ID of the Customer: " + e);
                    }
                } catch (IOException e) {
                    System.err.println("Failed to create I/O streams: " + e);
                }
            } catch (UnknownHostException e) {
                System.err.println("Invalid server IP address or DNS name specified: \"" + SERVER_IP + "\": " + e);
            }
            return false;
        }
    }
}