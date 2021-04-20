package com.example.jpa.books.actions;

import com.example.jpa.books.dao.AuthorDao;
import com.example.jpa.books.dao.BookDao;
import com.example.jpa.books.dao.EditionDao;
import com.example.jpa.books.view.EntityWindow;

import javax.inject.Inject;
import java.math.BigDecimal;
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
        Predicate<BigDecimal> priceRequirement = value -> value.compareTo(BigDecimal.ZERO) > 0;
        String errorMessage = "Price must be more then $0.00";
        BigDecimal newPrice = window.askForBigDecimal(label, priceRequirement, errorMessage);

        bookEdition.setPrice(newPrice);
        editionDao.update(bookEdition);
        window.displayEntity(bookEdition, "The edition is updated:");
    }
}
