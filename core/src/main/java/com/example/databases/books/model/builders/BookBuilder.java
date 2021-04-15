package com.example.databases.books.model.builders;

import com.example.databases.books.exceptions.BuilderAlreadyExecuted;
import com.example.databases.books.model.Author;
import com.example.databases.books.model.Book;

public class BookBuilder {
    private final Book book = new Book("",  null);
    boolean executed = false;

    public BookBuilder() {
    }

    public BookBuilder setTitle(String title) {
        book.setTitle(title);
        return this;
    }

    public BookBuilder setAuthor(Author author) {
        book.setAuthor(author);
        return this;
    }

    public BookBuilder setId(int bookId) {
        book.setId(bookId);
        return this;
    }

    public Book build() {
        if(executed) {
            throw new BuilderAlreadyExecuted();
        }
        executed = true;
        return book;
    }


}
