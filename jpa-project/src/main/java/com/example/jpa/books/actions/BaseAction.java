package com.example.jpa.books.actions;

import com.example.jpa.books.dao.AuthorDao;
import com.example.jpa.books.dao.BookDao;
import com.example.jpa.books.dao.EditionDao;
import com.example.jpa.books.model.AuthorEntity;
import com.example.jpa.books.model.BookEditionEntity;
import com.example.jpa.books.model.BookEntity;
import com.example.jpa.books.view.EntityWindow;

import javax.inject.Inject;

public class BaseAction {
    @Inject
    private EntityWindow window;

    @Inject
    private AuthorDao authorDao;

    @Inject
    private BookDao bookDao;

    @Inject
    private EditionDao editionDao;

    protected AuthorEntity requestAuthor() {
        return window.selectElementFromList(authorDao.getAll(), "author");
    }

    protected BookEntity requestBookFromAuthor(AuthorEntity author) {
        var books = bookDao.getByAuthor(author);
        return window.selectElementFromList(books, "book");
    }

    protected BookEditionEntity requestEditionFromBook(BookEntity book) {
        var editions = editionDao.getByBook(book);
        return window.selectElementFromList(editions, "edition");
    }


}
