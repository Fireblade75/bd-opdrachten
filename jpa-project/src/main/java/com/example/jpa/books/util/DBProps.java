package com.example.jpa.books.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProps {
    private static String connectionString;
    private static String username;
    private static String password;

    static {
        connectionString = System.getenv("db_url");
        username = System.getenv("db_user");
        password = System.getenv("db_password");

        Properties props = new Properties();
        try (InputStream file = DBProps.class.getClassLoader().getResourceAsStream("db.properties")) {
            props.load(file);
            connectionString = connectionString != null ? connectionString : props.getProperty("db_url");
            username = username != null ? username : props.getProperty("db_user");
            password = password != null ? password : props.getProperty("db_password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConnectionString() {
        return connectionString;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
