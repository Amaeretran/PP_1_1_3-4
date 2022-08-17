package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import static jm.task.core.jdbc.util.Util.closeConnect;

public class Main {
    public static void main(String[] args) {
        User[] employee = new User[] {
                new User(),
                new User("Vasiliy", "Petrov", (byte) 20),
                new User("Sergey", "Ivancov", (byte) 35),
                new User("Zahar", "Gorelov", (byte) 60)
        };

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        for (User u : employee) {
            userService.saveUser(u.getName(), u.getLastName(), u.getAge());
            System.out.println("User named - " + u.getName() + " insert in database");
        }
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
        closeConnect();



    }
}
