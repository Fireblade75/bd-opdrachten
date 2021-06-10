package com.example.office.view;

import com.example.office.actions.core.ExitAction;
import com.example.office.actions.core.MenuAction;

import javax.inject.Inject;
import java.util.*;

import com.example.office.util.InjectLogger;
import com.sun.istack.NotNull;
import org.apache.logging.log4j.Logger;

public class WindowController {

    @InjectLogger
    private Logger logger;

    @Inject
    private EntityWindow window;

    private final Set<MenuAction> actions = new TreeSet<>();
    private boolean running = true;

    @Inject
    public WindowController(Set<MenuAction> menuActions) {
        menuActions.stream()
                .filter(menuAction -> {
                    String actionName = menuAction.getActionName();
                    return actionName != null && !actionName.isBlank();
                })
                .forEach(actions::add);
    }

    public void windowLoop() {
        while (running) {
            MenuAction menuAction = window.selectElementFromSet(
                    actions, "action", MenuAction::getActionName);

            logger.info("Running action " + menuAction.getActionName());
            if(menuAction instanceof ExitAction) {
                running = false;
            } else {
                menuAction.runAction();
                window.displayLine("");
            }
        }
    }
}

