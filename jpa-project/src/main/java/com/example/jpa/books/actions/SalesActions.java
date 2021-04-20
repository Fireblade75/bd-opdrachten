package com.example.jpa.books.actions;

import com.example.jpa.books.dao.SaleDao;
import com.example.jpa.books.model.SaleEntity;
import com.example.jpa.books.view.EntityWindow;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class SalesActions extends BaseAction {

    @Inject
    private EntityWindow window;

    @Inject
    private SaleDao saleDao;

    public void performSale() {
        var author = requestAuthor();
        var book = requestBookFromAuthor(author);
        var bookEdition = requestEditionFromBook(book);

        boolean accepted = window.askYesNoQuestion("Do you want to buy this book?");

        if(accepted) {
            saleDao.addSale(bookEdition);
        }
    }

    public void viewSales() {
        List<SaleEntity> salesEntities = saleDao.getLastSales(10);
        window.displayEntities(salesEntities, "Recent sales:");
    }

    public void undoLastSale() {
        Optional<SaleEntity> optionalSale = saleDao.removeLastSale();
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
