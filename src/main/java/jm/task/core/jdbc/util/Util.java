package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // JDBC поля.
    private static final String DATABASE_URL = "jdbc:mysql://localhost/store";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    private static Connection connection;
    // Hibernate поля.
    private static SessionFactory sessionFactory;

    private Util() {

    }

    // JDBC методы.
    public static Connection getConnection() {
        try {
            connection =  DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Connection successful.");
        } catch (SQLException e) {
            System.out.println("Connection ERROR. Retry connection...");
            for (int i = 0; i < 10; i++) {
                getConnection();
            }
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }
    public static void closeConnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Hibernate методы.

    public static Session getSession() {
        return sessionFactory.openSession();
    }
    public static void build() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperties(hibernateProperties());
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void shutdown() {
        if(sessionFactory != null) {
            sessionFactory.close();
        }
    }

    private static Properties hibernateProperties(){
        final Properties properties = new Properties();

        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver" );
        properties.put(Environment.URL, DATABASE_URL);
        properties.put(Environment.USER, USER );
        properties.put(Environment.PASS, PASSWORD );
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "");

        return properties;
    }
}