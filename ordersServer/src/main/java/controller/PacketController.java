package controller;

import domain.Packet;
import utils.PacketUtils;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PacketController {

    public boolean sendPacket(byte code, byte[] data, ObjectOutputStream output) {
        return PacketUtils.sendPacket(code, data, output);
    }

    public Packet receivePacket(ObjectInputStream input) {
        return PacketUtils.receivePacket(input);
    }
}