package com.example.jpa.books;

import com.example.jpa.books.dao.AuthorDao;
import com.example.jpa.books.dao.BookDao;
import com.example.jpa.books.model.AuthorEntity;
import com.example.jpa.books.model.BookEntity;
import com.example.jpa.books.view.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class BooksMain {
    private static final Logger logger = LogManager.getLogger(BooksMain.class);

    public static void main(String[] args) throws IOException {
        AuthorDao authorDao = AuthorDao.INSTANCE;
        BookDao bookDao = BookDao.INSTANCE;

        Window window = new Window();
        var author = window.selectElementFromList(authorDao.getAll(), "book");
        var books = bookDao.getByAuthor(author);
        BookEntity book = window.selectElementFromList(books, "book");


//        AuthorDao authorDao = AuthorDao.INSTANCE;
//        var author = authorDao.get(1);
//        System.out.println(author);
//        logger.warn(author.getFirstName() + " " + author.getLastName());
    }

}
