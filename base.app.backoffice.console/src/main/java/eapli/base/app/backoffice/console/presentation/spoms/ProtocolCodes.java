package eapli.base.app.backoffice.console.presentation.spoms;

public enum ProtocolCodes {
    COMMTEST(0),
    DISCONN(1),
    ACK(2),
    MSG(3);
    private final byte codeKey;

    //TODO: from byte to unsigned integer
    ProtocolCodes(int codeKey) {
        this.codeKey = intToByte(codeKey);
    }

    public static ProtocolCodes parseCode(byte code) throws CommunicationException {
        switch (code) {
            case 0:
                return COMMTEST;
            case 1:
                return DISCONN;
            case 2:
                return ACK;
            case 3:
                return MSG;
            default:
                throw new CommunicationException(String.format("Protocol code %d not recognized", code));
        }
    }

    public byte getCodeKey() {
        return codeKey;
    }

    private static byte intToByte(int codeKey) {
        return ((byte) (codeKey % 256));
    }
}