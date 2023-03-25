package utils;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetAddress;

public class SocketUtils {
    /**
     * Creates a server socket to accept connections from clients.
     */
    public static SSLServerSocket createSocketServer(int port) {
        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            return (SSLServerSocket) ssf.createServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a client socket to connect to the server.
     */
    public static SSLSocket createSocketClient(InetAddress ip, int port) {
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            return (SSLSocket) ssf.createSocket(ip, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
