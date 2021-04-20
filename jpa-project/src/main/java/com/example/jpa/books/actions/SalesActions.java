package com.example.jpa.books.actions;

import com.example.jpa.books.dao.AuthorDao;
import com.example.jpa.books.dao.BookDao;
import com.example.jpa.books.dao.EditionDao;
import com.example.jpa.books.dao.SalesDao;
import com.example.jpa.books.model.BookEntity;
import com.example.jpa.books.model.SaleEntity;
import com.example.jpa.books.view.Window;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class SalesActions {

    @Inject
    private Window window;

    @Inject
    private AuthorDao authorDao;

    @Inject
    private BookDao bookDao;

    @Inject
    private EditionDao editionDao;

    @Inject
    private SalesDao salesDao;

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

    public void viewSales() {
        List<SaleEntity> salesEntities = salesDao.getLastSales(10);
        window.displayEntities(salesEntities, "Recent sales:");
    }

    public void undoLastSale() {
        Optional<SaleEntity> optionalSale = salesDao.removeLastSale();
        optionalSale.ifPresentOrElse(
                (sale -> {
                    window.displayEntity(sale, "The following sale was removed:");
                }),
                () -> {
                    window.displayText("No sales found");
                }
        );
    }
}
