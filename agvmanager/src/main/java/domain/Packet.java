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

    public byte getVersion() {
        return version;
    }

    public byte getCode() {
        return code;
    }

    public byte getLength() {
        return (byte) (dLength1 + 256 * dLength2);
    }

    public byte[] getData() {
        return data;
    }
}