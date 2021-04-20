package com.example.jpa.books.actions;

import com.example.jpa.books.dao.SalesDao;
import com.example.jpa.books.model.SaleEntity;
import com.example.jpa.books.view.EntityWindow;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class SalesActions extends BaseAction {

    @Inject
    private EntityWindow window;

    @Inject
    private SalesDao salesDao;

    public void performSale() {
        var author = requestAuthor();
        var book = requestBookFromAuthor(author);
        var bookEdition = requestEditionFromBook(book);

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
                    window.displayLine("No sales found");
                }
        );
    }
}
