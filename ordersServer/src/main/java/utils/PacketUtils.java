package utils;

import domain.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PacketUtils {
    public static boolean sendPacket(byte code, byte[] data, ObjectOutputStream output) {
        Packet packet = new Packet((byte) 0, code, data);
        try {
            output.writeObject(packet);
            return true;
        } catch (IOException e) {
            System.err.println("Failed to send the packet through the output stream: " + e);
            return false;
        }
    }
    public static Packet receivePacket(ObjectInputStream input) {
        try {
            return (Packet) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to receive a packet through the input stream: " + e);
            return null;
        }
    }
}
