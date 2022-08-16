package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import static jm.task.core.jdbc.util.Util.closeConnect;

public class Main {
    public static void main(String[] args) {
        User[] emp = new User[] {
                new User(),
                new User("Vasiliy", "Petrov", (byte) 20),
                new User("Sergey", "Ivancov", (byte) 35),
                new User("Zahar", "Gorelov", (byte) 60)
        };

        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        for (User u : emp) {
            usi.saveUser(u.getName(), u.getLastName(), u.getAge());
            System.out.println("User named - " + u.getName() + " insert in database");
        }
        System.out.println(usi.getAllUsers());
        usi.cleanUsersTable();
        usi.dropUsersTable();
        closeConnect();



    }
}
