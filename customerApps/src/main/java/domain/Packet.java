package domain;

import java.io.Serializable;

public class Packet implements Serializable {
    private final byte version;
    private final byte code;
    private byte dLength1;
    private byte dLength2;
    private final byte[] data;

    public Packet(byte version, byte code, byte[] data) {
        this.version = version;
        this.code = code;
        this.data = data;
    }

    public Packet(byte version, byte code, byte[] data, byte dLength1, byte dLength2) {
        this.version = version;
        this.code = code;
        this.data = data;
        this.dLength1 = dLength1;
        this.dLength2 = dLength2;
    }

    public byte getVersion() {
        return version;
    }

    public byte getCode() {
        return code;
    }

    public byte getLength() {
        return (byte) Math.multiplyExact(Math.addExact(dLength1, 256), dLength2);
    }

    public byte[] getData() {
        return data;
    }
}
