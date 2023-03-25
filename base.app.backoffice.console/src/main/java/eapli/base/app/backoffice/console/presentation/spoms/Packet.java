package eapli.base.app.backoffice.console.presentation.spoms;

import java.io.Serializable;

public class Packet implements Serializable {
    private final byte version;
    private byte[] data;
    private final int MAX_SIZE = 254;
    private byte code;
    private int length;
    private byte dLength1;
    private byte dLength2;

    public Packet(byte version, byte code) {
        this.version = version;
        this.code = code;
        this.length = 0;
        // TODO calculate dlengths
        this.dLength1 = (byte) 255;
        this.dLength2 = (byte) 222;
    }

    public byte getVersion() {
        return version;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte codeKey) {
        code = codeKey;
    }

    public int getLength() {
        return length;
    }

    public byte getDLength1() {
        return dLength1;
    }

    public byte getdLength2() {
        return dLength2;
    }

    public void calculateLengths() {
        int total = 0;

        if (length == 0) {
            this.dLength1 = 0;
            this.dLength2 = 0;
        }

        if(dLength2 == 0) {
            length = dLength1;
        } else {
            total = dLength1 + 256 * dLength2;
        }

        System.out.println("Length Total: " + total);
    }

    public byte[] getContent() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public boolean canAdd() {
        return length != MAX_SIZE;
    }
}
