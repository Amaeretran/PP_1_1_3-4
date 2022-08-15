package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final Util connect = new Util();
    private static final String table = "Users";
    public UserDaoJDBCImpl() {
        connect.connect();
    }

    public void createUsersTable() {
        try {
            connect.s.executeUpdate("CREATE TABLE " + table + " (id INT AUTO_INCREMENT PRIMARY KEY, name TEXT, lastName TEXT, age INTEGER NOT NULL)");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void dropUsersTable() {
        try {
            connect.s.executeUpdate("DROP TABLE " + table);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            connect.s.executeQuery("INSERT " + table + "(name, lastName, age) VALUES (" + name + "," + lastName + "," + age + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
            connect.s.executeQuery("DELETE FROM " + table + " WHERE id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        try {
            return (List<User>) connect.s.executeQuery("SELECT * FROM " + table);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void cleanUsersTable() {
        try {
            connect.s.executeUpdate("TRUNCATE " + table);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
