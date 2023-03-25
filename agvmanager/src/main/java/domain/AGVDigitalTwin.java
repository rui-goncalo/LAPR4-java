package domain;

import controller.PacketUtilsController;
import controller.SocketUtilsController;
import controller.UtilsController;
import utils.Constants;
import utils.Pathfinding;

import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class AGVDigitalTwin {

    private SSLSocket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private final Pathfinding pathfinding = new Pathfinding();

    private Coordinates baseLocation;
    private Coordinates currentLocation;
    private float battery = 100f;

    private final PacketUtilsController packetUtilsController = new PacketUtilsController();
    private final SocketUtilsController socketUtilsController = new SocketUtilsController();
    private final UtilsController utilsController = new UtilsController();

    public void run(String[] args) {
        if (args.length == 0) {
            System.err.println("Server IP address or DNS name is required as an argument.");
            return;
        }

        if (!performSetup(args)) return;

        List<Coordinates> paths;

        while (true) {
            while (true) {
                Packet packet = packetUtilsController.receivePacket(input);
                if (packet == null) return;
                if (packet.getCode() != ProtocolCodes.JOB_ASSIGN.getCodeKey()) break;

                Coordinates task = new Coordinates().getObject(packet.getData());
                paths = pathfinding.breadthFirstSearch(Constants.warehouseMatrix, currentLocation.getxPos(), currentLocation.getyPos(), task.getxPos(), task.getyPos());
                System.out.println("\nHeaded to Location: " + task + "\n");

                while (!paths.isEmpty()) {
                    currentLocation = paths.remove(0);
                    sendCurrentPosition();
                    utilsController.sleepSeconds(1);
                }

                System.out.println("\nArrived at Location: " + task + "\n");
                paths = pathfinding.breadthFirstSearch(Constants.warehouseMatrix, currentLocation.getxPos(), currentLocation.getyPos(), baseLocation.getxPos(), baseLocation.getyPos());

                while (!paths.isEmpty()) {
                    currentLocation = paths.remove(0);
                    sendCurrentPosition();
                    utilsController.sleepSeconds(1);
                }

                if (battery < 50) {
                    packetUtilsController.sendPacket(ProtocolCodes.AGV_CHARGING.getCodeKey(), null, output);

                    do {
                        battery++;
                        System.out.println("Battery: " + battery + "%");
                        utilsController.sleepMilliseconds(200);
                    } while (battery != 100);
                }

                packetUtilsController.sendPacket(ProtocolCodes.JOB_COMPLETE.getCodeKey(), null, output);
            }
        }
    }

    /**
     * Performs the initial setup for the AGV Digital Twin to be able to communicate with the server.
     */
    private boolean performSetup(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\tezla\\Documents\\ISEP\\lei21_22_s4_2dk_03\\agvmanager\\src\\main\\resources\\clientTrustStore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        try {
            InetAddress serverIP = InetAddress.getByName(args[0]);
            socket = socketUtilsController.createSocketClient(serverIP, 2223); //10753 // 2223

            try {
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());

                try {
                    packetUtilsController.sendPacket(ProtocolCodes.SETUP.getCodeKey(), args[1].getBytes(), output);

                    Packet packet = packetUtilsController.receivePacket(input);
                    baseLocation = new Coordinates().getObject(packet.getData());
                    currentLocation = new Coordinates().getObject(packet.getData());

                    return true;
                } catch (Exception e) {
                    System.err.println("Failed to assign the ID of the AGV: " + e);
                }
            } catch (IOException e) {
                System.err.println("Failed to create I/O streams: " + e);
            }
        } catch (UnknownHostException e) {
            System.err.println("Invalid server IP address or DNS name specified: \"" + args[0] + "\": " + e);
        }
        return false;
    }

    /**
     * Sends the current position of the AGV to the AGV Manager.
     */
    private void sendCurrentPosition() {
        battery -= 2;
        packetUtilsController.sendPacket(ProtocolCodes.JOB_UPDATE.getCodeKey(), currentLocation.getBytes(currentLocation), output);
        System.out.print("Battery: " + battery + "% | ");
        System.out.println("Sent - " + currentLocation);
    }
}