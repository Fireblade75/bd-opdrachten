package com.example.databases;

import com.example.databases.books.exceptions.BookStoreException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection implements AutoCloseable {

    private Connection con;

    public MySqlConnection() throws SQLException {
        String sqlPassword = System.getenv("mysql_password");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306?" +
                "user=root&password=" + sqlPassword);

    }

    protected Connection getConnection() {
        return con;
    }

    public void close() throws SQLException {
        con.close();
    }
}
