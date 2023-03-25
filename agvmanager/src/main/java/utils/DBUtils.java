package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    private static final String DB_URL = "jdbc:h2:tcp://vsgate-s2.dei.isep.ipp.pt:10141/db";
    private static final String DB_USERNAME = "";
    private static final String DB_PASSWORD = "fcXPDZ5tuxxe";

    /**
     * Creates a connection to the database.
     */
    public static Connection createConnection() {
        try {
            Class.forName("org.h2.Driver");
            try {
                return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Executes any type of update query.
     */
    public static boolean executeQuery(String query, Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.err.println("Failed to execute the following query: \"" + query + "\": " + e);
            return false;
        }
    }
}