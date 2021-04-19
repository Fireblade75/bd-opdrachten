package com.example.jpa.books;

import com.example.jpa.books.actions.ActionList;
import com.example.jpa.books.actions.PerformSale;
import com.example.jpa.books.actions.ViewSales;
import com.example.jpa.books.dao.AuthorDao;
import com.example.jpa.books.dao.BookDao;
import com.example.jpa.books.dao.EditionDao;
import com.example.jpa.books.model.AuthorEntity;
import com.example.jpa.books.model.BookEntity;
import com.example.jpa.books.view.Window;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BooksMain {
    private static final Logger logger = LogManager.getLogger(BooksMain.class);

    public static void main(String[] args) {
        try(Window window = new Window()) {

            PerformSale performSale = new PerformSale(window);
            List<String> actions = Arrays.asList(ActionList.ACTION_LIST);
            ViewSales viewSales = new ViewSales();

            boolean running = true;
            while (running) {
                int actionId = window.selectIdFromList(actions, "action");
                switch (actionId) {
                    case ActionList.BUY_BOOK_INDEX:
                        performSale.performSale();
                        break;
                    case ActionList.VIEW_SALES_INDEX:
                        viewSales.viewSales();
                        break;
                    case ActionList.EXIT_INDEX:
                        running = false;
                        break;
                    default:
                        if(actionId >= 0 && actionId < ActionList.ACTION_LIST.length) {
                            logger.error("Unsupported action: " + ActionList.ACTION_LIST[actionId]);
                        } else {
                            logger.error("Unknown action: " + actionId);
                        }
                }
            }
        } catch (IOException e) {
            logger.error(e);
        }


//        AuthorDao authorDao = AuthorDao.INSTANCE;
//        var author = authorDao.get(1);
//        System.out.println(author);
//        logger.warn(author.getFirstName() + " " + author.getLastName());
    }

}
