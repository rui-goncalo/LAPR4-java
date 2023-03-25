package domain;

import controller.PacketController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PacketTest {
    @Test
    public void packetTest(){
        byte version = 0;
        byte code = ProtocolCodes.SETUP.getCodeKey();
        byte[] data = "Packet Test".getBytes();
        byte dLength1 = 1;
        byte dLength2 = 2;


        Packet packet = new Packet(version, code, data, dLength2, dLength1);

        assertEquals(packet.getVersion(), version);
        assertEquals(packet.getCode(), code);
        assertEquals(packet.getData(), data);
        assertEquals(packet.getLength(), dLength2);
    }
}
