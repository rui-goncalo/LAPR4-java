package controller;

import domain.OrdersServer;

import java.sql.Connection;

public class DBController {

    public Connection createConnection() {
        return OrdersServer.createConnection();
    }

    public String executeUpdateQuery(String query) {
        return OrdersServer.executeUpdateQuery(query);
    }

    public String executeQuery(String query, Connection connection, String table) {
        return OrdersServer.executeQuery(query, connection, table);
    }
}
