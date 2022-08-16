package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final Util connect = new Util();
    private static final String create = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30), lastName VARCHAR(30), age INTEGER NOT NULL)";
    private static final String drop = "DROP TABLE users";
    private static final String save = "INSERT users (users.name, users.lastName, users.age) VALUES ('";
    private static final String remove = "DELETE FROM users WHERE id = ";
    private static final String get = "SELECT * FROM users";
    private static final String clean = "TRUNCATE users";
    public UserDaoJDBCImpl() {
        connect.connect();
    }

    public void createUsersTable() {
        try {
            connect.s.executeUpdate(create);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        try {
            connect.s.executeUpdate(drop);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            connect.s.executeUpdate(save + name + "', '" + lastName + "'," + age + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
            connect.s.executeUpdate(remove + id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        try {
            List<User> lu = new LinkedList<>();
            ResultSet rs = connect.s.executeQuery(get);
            while (rs.next()) {
                byte a = (byte) rs.getInt("age");
                String n = rs.getString("name");
                String ln = rs.getString("lastName");
                long i = rs.getInt("id");
                User user = new User(n, ln, a);
                user.setId(i);
                lu.add(user);
            }
            return lu;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void cleanUsersTable() {
        try {
            connect.s.executeUpdate(clean);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
