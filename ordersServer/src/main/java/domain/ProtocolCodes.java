package domain;

public enum ProtocolCodes {

    TEST((byte) 0),

    DISCONNECT((byte) 1),

    ACKNOWLEDGEMENT((byte) 2),

    SETUP((byte) 3),
    JOB_LOGIN((byte) 4),
    JOB_ORDER_CHECK_STATUS((byte) 5),

    JOB_PRODUCT_OPTION((byte) 6),
    JOB_ADD_PRODUCT((byte) 7),

    JOB_COMPLETE((byte) 8);
    private final byte codeKey;
    ProtocolCodes(byte codeKey) {
        this.codeKey = codeKey;
    }
    public byte getCodeKey() {
        return codeKey;
    }
}
