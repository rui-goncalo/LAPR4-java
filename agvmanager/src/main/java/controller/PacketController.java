package controller;

import domain.Packet;

public class PacketController {
    public Packet createPacket(byte version, byte code, byte[] data) {
        return new Packet(version, code, data);
    }
}