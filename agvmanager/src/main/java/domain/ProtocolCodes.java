package domain;

public enum ProtocolCodes {
    SETUP((byte) 1),
    JOB_ASSIGN((byte) 2),
    JOB_START((byte) 3),
    JOB_UPDATE((byte) 4),
    JOB_COMPLETE((byte) 5),
    AGV_CHARGING((byte) 6);

    private final byte codeKey;

    ProtocolCodes(byte codeKey) {
        this.codeKey = codeKey;
    }

    public byte getCodeKey() {
        return codeKey;
    }
}