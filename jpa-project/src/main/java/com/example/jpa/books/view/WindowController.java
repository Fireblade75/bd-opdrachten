package com.example.jpa.books.view;

import com.example.jpa.books.actions.ActionList;
import com.example.jpa.books.actions.BookActions;
import com.example.jpa.books.actions.SalesActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class WindowController {

    private static final Logger logger = LogManager.getLogger(WindowController.class);
    private static final List<String> actions = Arrays.asList(ActionList.ACTION_LIST);

    @Inject
    EntityWindow window;

    @Inject
    SalesActions salesActions;

    @Inject
    BookActions bookActions;

    public void windowLoop() {
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
                        window.displayLine("This action is currently not supported");
                        logger.error("Unsupported action: " + ActionList.ACTION_LIST[actionId]);
                    } else {
                        logger.error("Unknown action: " + actionId);
                    }
            }
            window.displayLine("");
        }
    }
}
