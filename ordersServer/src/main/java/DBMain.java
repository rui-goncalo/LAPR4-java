import app.OrdersServerApp;
import controller.DBController;
import domain.OrdersServer;

import java.sql.Connection;

public class DBMain {
    public static void main(String[] args) {
        new OrdersServerApp().run();
    }
}
