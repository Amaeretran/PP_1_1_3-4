package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String DATABASE_URL = "jdbc:mysql://localhost/store";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    private static final String[] SQL = new String[] {
      "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30), lastName VARCHAR(30), age INTEGER NOT NULL)",
      "INSERT users (users.name, users.lastName, users.age) VALUES (?, ?, ?)",
      "DELETE FROM users WHERE id = ?",
      "DROP TABLE IF EXISTS users",
      "SELECT * FROM users",
      "TRUNCATE users"
    };
    private static Connection connection;
    public static PreparedStatement[] statement = new PreparedStatement[SQL.length];

    private Util() {

    }

    public static void connect() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Connection successful.");
            for (int i = 0; i < SQL.length; i++) {
                statement[i] = connection.prepareStatement(SQL[i]);
            }
        } catch (SQLException e) {
            System.out.println("Connection ERROR. Retry connection...");
            for (int i = 0; i < 10; i++) {
                connect();
            }
            System.out.println(e.getMessage());
        }
    }
    public static void closeConnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}
