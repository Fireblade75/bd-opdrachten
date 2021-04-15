package com.example.databases.books.exceptions;

import java.sql.SQLException;

public class BookStoreException extends RuntimeException {
    private static final long serialVersionUID = 7720357027914648855L;

    public BookStoreException(SQLException e) {
        super(e);
    }

    public BookStoreException() {

    }

    public BookStoreException(String message) {
        super(message);
    }
}
