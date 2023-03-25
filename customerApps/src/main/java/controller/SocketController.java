package controller;

import utils.SocketUtils;

import javax.net.ssl.SSLSocket;
import java.net.InetAddress;

public class SocketController {

    public SSLSocket createSocketClient(InetAddress ip, int port) {
        return SocketUtils.createSocketClient(ip, port);
    }
}
