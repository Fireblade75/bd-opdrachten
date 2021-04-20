package com.example.jpa.books;

import com.example.jpa.books.actions.ActionList;
import com.example.jpa.books.actions.SalesActions;
import com.example.jpa.books.view.Window;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BooksMain {
    private static final Logger logger = LogManager.getLogger(BooksMain.class);

    public static void main(String[] args) {
        try(Window window = new Window()) {
            Injector injector = Guice.createInjector(binder -> {
                binder.bind(Window.class).toInstance(window);
            });

            SalesActions salesActions = injector.getInstance(SalesActions.class);
            List<String> actions = Arrays.asList(ActionList.ACTION_LIST);

            boolean running = true;
            while (running) {
                int actionId = window.selectIdFromList(actions, "action");
                switch (actionId) {
                    case ActionList.BUY_BOOK_INDEX:
                        salesActions.performSale();
                        break;
                    case ActionList.VIEW_SALES_INDEX:
                        salesActions.viewSales();
                        break;
                    case ActionList.UNDO_LAST_SALE_INDEX:
                        salesActions.undoLastSale();
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
                window.displayText("");
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }

}
