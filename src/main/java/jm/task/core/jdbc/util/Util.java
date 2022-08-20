package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/store";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    private static Connection connection;

    private Util() {

    }

    public static Connection getConnection() {
        try {
            connection =  DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Connection successful.");
        } catch (SQLException e) {
            System.out.println("Connection ERROR. Retry connection...");
            for (int i = 0; i < 10; i++) {
                getConnection();
            }
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }
    public static void closeConnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
