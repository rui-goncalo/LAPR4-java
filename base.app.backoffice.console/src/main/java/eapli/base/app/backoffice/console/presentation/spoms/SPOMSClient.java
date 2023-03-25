package eapli.base.app.backoffice.console.presentation.spoms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SPOMSClient {


    private static InetAddress serverIP;
    private static Socket sock;
    private static ObjectOutputStream sOut;
    private static ObjectInputStream sIn;
    private static byte PROTOCOL_VERSION = 0;

    public static void main(String args[]) throws Exception {
        if (args.length != 1) {
            System.out.println("Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + args[0]);
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, 9999);
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
            System.exit(1);
        }

        sOut = new ObjectOutputStream(sock.getOutputStream());
        sIn = new ObjectInputStream(sock.getInputStream());
        byte packetCode = ProtocolCodes.COMMTEST.getCodeKey();
        while (packetCode != ProtocolCodes.DISCONN.getCodeKey()) {
            Packet packet = new Packet((byte) 0, ProtocolCodes.MSG.getCodeKey());
            packet.setData("AVAILABLEAGVS_Q".getBytes(StandardCharsets.UTF_8));
            sendPacket(packet);
            Packet answer = readPacket();
            if (answer.getCode() == ProtocolCodes.MSG.getCodeKey()) {
                String message = new String(answer.getContent(), StandardCharsets.UTF_8);
                System.out.println(message);
            }
            Packet exit = readPacket();
            packetCode = exit.getCode();
        }

        sock.close();
    }

    public static void sendTest() throws CommunicationException {
        Packet packet = new Packet(PROTOCOL_VERSION, ProtocolCodes.COMMTEST.getCodeKey());
        sendPacket(packet);
    }

    public static void sendExit() throws CommunicationException {
        Packet packet = new Packet(PROTOCOL_VERSION, ProtocolCodes.DISCONN.getCodeKey());
        sendPacket(packet);
    }

    public static void sendAcknowledge() throws CommunicationException {
        Packet packet = new Packet(PROTOCOL_VERSION, ProtocolCodes.ACK.getCodeKey());
        sendPacket(packet);
    }

    public static void sendPacket(Packet packet) throws CommunicationException {
        try {
            sOut.writeObject(packet);
        } catch(IOException e) {
            throw new CommunicationException("Could not send packet", e);
        }

    }

    public static Packet readPacket() throws CommunicationException {
        try {
            return ((Packet) sIn.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new CommunicationException("Could not read packet", e);
        }
    }
}
