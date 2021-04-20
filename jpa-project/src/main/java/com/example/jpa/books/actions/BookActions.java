package com.example.jpa.books.actions;

import com.example.jpa.books.dao.AuthorDao;
import com.example.jpa.books.dao.BookDao;
import com.example.jpa.books.dao.EditionDao;
import com.example.jpa.books.view.EntityWindow;

import javax.inject.Inject;
import java.util.function.Predicate;

public class BookActions extends BaseAction {

    @Inject
    private EntityWindow window;

    @Inject
    private AuthorDao authorDao;

    @Inject
    private BookDao bookDao;

    @Inject
    private EditionDao editionDao;

    public void modifyPrice() {
        var author = requestAuthor();
        var book = requestBookFromAuthor(author);
        var bookEdition = requestEditionFromBook(book);

        String label = "Give a new price for the book";
        Predicate<Double> priceRequirement = value -> value > 0;
        String errorMessage = "Price must be more then $0.00";
        double newPrice = window.askForDouble(label, priceRequirement, errorMessage);

    }
}
