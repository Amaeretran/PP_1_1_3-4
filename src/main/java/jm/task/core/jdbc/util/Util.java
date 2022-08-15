package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static String dbURL = "jdbc:mysql://localhost/store";
    private static String user = "admin";
    private static String password = "admin";
    //private Statement s;
    // реализуйте настройку соеденения с БД

    public void connect() throws SQLException {
        try (Connection c = DriverManager.getConnection(dbURL, user, password)) {

        }
    }

}
