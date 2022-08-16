package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String dbURL = "jdbc:mysql://localhost/store";
    private static final String user = "admin";
    private static final String password = "admin";
    private static Connection c;
    public Statement s;
    private int count = 0;

    public void connect() {
        try {
            c = DriverManager.getConnection(dbURL, user, password);
            System.out.println("Connection successful.");
            s = c.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection ERROR. Retry connection...");
            if (++count < 10) {
                connect();
            } else {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void closeConnect() {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
