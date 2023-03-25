package controller;

import utils.SocketUtils;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.net.InetAddress;

public class SocketUtilsController {
    public SSLServerSocket createServerSocket(int port) {
        return SocketUtils.createSocketServer(port);
    }

    public SSLSocket createSocketClient(InetAddress ip, int port) {
        return SocketUtils.createSocketClient(ip, port);
    }
}