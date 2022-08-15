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
    // реализуйте настройку соеденения с БД

    public void connect() {
        try {
            c = DriverManager.getConnection(dbURL, user, password);
            System.out.println("Соединение установлено.");
            s = c.createStatement();
        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение. Повторяю попытку...");
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
