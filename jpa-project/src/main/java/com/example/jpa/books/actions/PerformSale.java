package com.example.jpa.books.actions;

import com.example.jpa.books.dao.AuthorDao;
import com.example.jpa.books.dao.BookDao;
import com.example.jpa.books.dao.EditionDao;
import com.example.jpa.books.dao.SalesDao;
import com.example.jpa.books.model.BookEntity;
import com.example.jpa.books.view.Window;

public class PerformSale {

    private Window window;
    private AuthorDao authorDao = AuthorDao.INSTANCE;
    private BookDao bookDao = BookDao.INSTANCE;
    private EditionDao editionDao = EditionDao.INSTANCE;
    private SalesDao salesDao = SalesDao.INSTANCE;

    public PerformSale(Window window) {
        this.window = window;
    }

    public void performSale() {
        System.out.println("perform sale");
        var author = window.selectElementFromList(authorDao.getAll(), "book");

        var books = bookDao.getByAuthor(author);
        BookEntity book = window.selectElementFromList(books, "book");

        var editions = editionDao.getByBook(book);
        var bookEdition = window.selectElementFromList(editions, "edition");

        boolean accepted = window.askYesNoQuestion("Do you want to buy this book?");

        if(accepted) {
            salesDao.addSale(bookEdition);
        }
    }
}
