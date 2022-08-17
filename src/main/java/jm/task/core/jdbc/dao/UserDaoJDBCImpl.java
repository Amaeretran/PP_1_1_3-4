package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.connect;
import static jm.task.core.jdbc.util.Util.statement;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
        connect();
    }

    public void createUsersTable() {
        try {
            statement[0].execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void dropUsersTable() {
        try {
            statement[3].executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            statement[1].setString(1, name);
            statement[1].setString(2, lastName);
            statement[1].setByte(3, age);
            statement[1].executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        try {
            statement[2].setLong(1, id);
            statement[2].executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        try {
            List<User> userList = new LinkedList<>();
            ResultSet resultSet = statement[4].executeQuery();
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
            statement[5].executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
