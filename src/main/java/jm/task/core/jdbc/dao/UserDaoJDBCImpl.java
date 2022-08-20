package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30), lastName VARCHAR(30), age INTEGER NOT NULL)";
    private static final String DROP = "DROP TABLE IF EXISTS users";
    private static final String SAVE = "INSERT users (users.name, users.lastName, users.age) VALUES (?, ?, ?)";
    private static final String REMOVE = "DELETE FROM users WHERE id = ?";
    private static final String GET = "SELECT * FROM users";
    private static final String CLEAN = "TRUNCATE users";
    private static Connection connect;

    public UserDaoJDBCImpl() {
        connect = getConnection();
    }

    public void createUsersTable() {
        try {
            connect.prepareStatement(CREATE).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void dropUsersTable() {
        try {
            connect.prepareStatement(DROP).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement save = connect.prepareStatement(SAVE);
            save.setString(1, name);
            save.setString(2, lastName);
            save.setByte(3, age);
            save.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
            PreparedStatement remove = connect.prepareStatement(REMOVE);
            remove.setLong(1, id);
            remove.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        try {
            List<User> userList = new LinkedList<>();
            ResultSet resultSet = connect.prepareStatement(GET).executeQuery();
            while (resultSet.next()) {
                byte age = (byte) resultSet.getInt("age");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                long id = resultSet.getInt("id");
                User user = new User(name, lastName, age);
                user.setId(id);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void cleanUsersTable() {
        try {
            connect.prepareStatement(CLEAN).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}