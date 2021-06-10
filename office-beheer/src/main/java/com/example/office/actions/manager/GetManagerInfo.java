package com.example.office.actions.manager;

import com.example.office.actions.core.MenuAction;
import com.example.office.dao.ManagerDao;
import com.example.office.model.Employee;
import com.example.office.model.Manager;
import com.example.office.view.EntityWindow;

import javax.inject.Inject;
import java.util.Optional;

public class GetManagerInfo extends MenuAction {

    @Inject
    EntityWindow window;

    @Inject
    ManagerDao managerDao;

    @Override
    public void runAction() {
        String name = window.askForString("Give the name of the manager");
        Optional<Manager> optionalManager = managerDao.findByName(name);

        if(optionalManager.isEmpty()) {
            window.displayLine("Err: Manager not found");
            return;
        }

        Manager manager = optionalManager.get();
        window.displayLine(manager.toManagerTable());
    }

    @Override
    public String getActionName() {
        return "Get manager info";
    }

    @Override
    public int priority() {
        return -5;
    }
}
