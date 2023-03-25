package controller;

import utils.DBUtils;

import java.sql.Connection;

public class DBUtilsController {

    public Connection createConnection() {
        return DBUtils.createConnection();
    }

    public boolean executeQuery(String query, Connection connection) {
        return DBUtils.executeQuery(query, connection);
    }
}