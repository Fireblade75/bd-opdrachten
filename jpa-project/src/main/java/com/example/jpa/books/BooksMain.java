package com.example.jpa.books;

import com.example.jpa.books.actions.ActionList;
import com.example.jpa.books.actions.SalesActions;
import com.example.jpa.books.view.EntityWindow;
import com.example.jpa.books.view.WindowController;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BooksMain {
    public static final String APP_TITLE = "Book App";

    private static final Logger logger = LogManager.getLogger(BooksMain.class);


    public static void main(String[] args) {
        try(EntityWindow window = new EntityWindow(APP_TITLE)) {

            Injector injector = Guice.createInjector(binder ->
                    binder.bind(EntityWindow.class).toInstance(window));

            WindowController windowController = injector.getInstance(WindowController.class);
            windowController.windowLoop();

        } catch (IOException e) {
            logger.error(e);
        }
    }

}
