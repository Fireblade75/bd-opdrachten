package com.example.office;

import com.example.office.actions.di.ActionModule;
import com.example.office.util.Log4JInjector;
import com.example.office.view.EntityWindow;
import com.example.office.view.WindowController;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class OfficeMain {
    private static final Logger logger = LogManager.getLogger(OfficeMain.class);
    public static final String APP_TITLE = "Office App";

    public static void main(String[] args) {
        try(EntityWindow window = new EntityWindow(APP_TITLE)) {

            Injector injector = Guice.createInjector(
                    binder -> binder.bind(EntityWindow.class).toInstance(window),
                    new ActionModule(),
                    new Log4JInjector()
            );

            WindowController windowController = injector.getInstance(WindowController.class);
            logger.info("Starting window loop");
            windowController.windowLoop();

        } catch (IOException e) {
            logger.error("Failed to create window", e);
        }
    }
}
