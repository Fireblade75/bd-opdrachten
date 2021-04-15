package com.example.databases.books.dao;

import com.example.databases.MySqlConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class BookSqlConnection extends MySqlConnection {
    public BookSqlConnection() throws SQLException {
        super();
        getConnection().setCatalog("bookstore");
    }

    @Override
    protected Connection getConnection() {
        return super.getConnection();
    }
}
