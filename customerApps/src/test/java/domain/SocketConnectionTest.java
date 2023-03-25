package domain;

import org.junit.Test;
import utils.SocketUtils;

import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class SocketConnectionTest {
        @Test
        public void socketConnectionTest() throws IOException {
            SSLSocket cs = SocketUtils.createSocketClient(InetAddress.getByName("google.com"), 443);

            InputStream in = cs.getInputStream();
            OutputStream out = cs.getOutputStream();

            out.write(1);

            while (in.available() > 0) {
                System.out.print(in.read());
            }

            System.out.println("Successfully connected.");
        }
}
