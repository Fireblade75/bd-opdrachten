package com.example.databases.books.model.builders;

import com.example.databases.books.exceptions.BuilderAlreadyExecuted;
import com.example.databases.books.model.Book;
import com.example.databases.books.model.BookEdition;

import java.math.BigDecimal;

public class BookEditionBuilder {
    private final BookEdition bookEdition = new BookEdition(null, "", BigDecimal.ZERO);
    boolean executed = false;

    public BookEditionBuilder setBook(Book book) {
        bookEdition.setBook(book);
        return this;
    }

    public BookEditionBuilder setLabel(String label) {
        bookEdition.setLabel(label);
        return this;
    }

    public BookEditionBuilder setPrice(BigDecimal price) {
        bookEdition.setPrice(price);
        return this;
    }

    public BookEditionBuilder setId(int id) {
        bookEdition.setId(id);
        return this;
    }

    public BookEdition build() {
        if(executed) {
            throw new BuilderAlreadyExecuted();
        }
        executed = true;
        return bookEdition;
    }
}
