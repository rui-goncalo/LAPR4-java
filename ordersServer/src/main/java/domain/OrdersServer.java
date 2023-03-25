package domain;

import controller.PacketController;

import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersServer {
    private static final Logger logger = Logger.getLogger(OrdersServer.class.getName());
    private static final String DB_URL = "jdbc:h2:tcp://vsgate-s2.dei.isep.ipp.pt:10141/db";
    private static final String DB_USERNAME = "";
    private static final String DB_PASSWORD = "fcXPDZ5tuxxe";

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

    public static String executeUpdateQuery(String query) {
        Connection connection = createConnection();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            return "Update done!";
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to execute the following query: \"" + query + "\". \"" + e + "\"");
            return null;
        }
    }

    public static String executeQuery(String query, Connection connection, String table) {
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            switch (table) {
                case "order": {
                    StringBuilder sb = new StringBuilder();

                    while (rs.next()) {
                        sb.append("Order ID: ").append(rs.getString("ORDERID"));
                        sb.append(", Date: ").append(rs.getString("DATE"));
                        sb.append(", Payment Method: ").append(rs.getString("PAYMENT_METHOD"));
                        sb.append(", Price: ").append(rs.getString("PRICE"));
                        sb.append(", Shipment: ").append(rs.getString("SHIPMENT"));
                        sb.append(", Status: ").append(rs.getString("STATUS"));
                        sb.append("\n");
                    }
                    return sb.toString();
                }
                case "login":
                    StringBuilder sb = new StringBuilder();

                    while (rs.next()) {
                        sb.append(rs.getString(1));
                    }
                    return sb.toString();
                case "product":
                    StringBuilder stringBuilder = new StringBuilder();

                    while (rs.next()) {
                        stringBuilder.append("Product ID: ").append(rs.getString("ID"));
                        stringBuilder.append(", BarCode: ").append(rs.getString("BARCODE"));
                        stringBuilder.append(", Brande Name: ").append(rs.getString("BRANDNAME"));
                        stringBuilder.append(", Long Description: ").append(rs.getString("LONG_DESCRIPTION"));
                        stringBuilder.append(", Product's name: ").append(rs.getString("NAME"));
                        stringBuilder.append(", Price: ").append(rs.getString("PRICE"));
                        stringBuilder.append("\n");
                    }
                    return stringBuilder.toString();
                default:
                    System.out.println("Invalid table name.");
                    break;
            }

            while (rs.next()) {
                System.out.println("ID: " + rs.getString(1));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
