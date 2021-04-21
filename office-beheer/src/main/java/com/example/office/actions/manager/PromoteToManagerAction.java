package com.example.office.actions.manager;

import com.example.office.actions.core.MenuAction;
import com.example.office.dao.EmployeeDao;
import com.example.office.view.EntityWindow;

import javax.inject.Inject;

public class PromoteToManagerAction extends MenuAction {

    @Inject
    EmployeeDao employeeDao;

    @Inject
    EntityWindow entityWindow;

    @Override
    public void runAction() {
        String name = entityWindow.askForString("Give the name of the employee");
        employeeDao.findByName(name);
    }

    @Override
    public String getActionName() {
        return "Promote to manager";
    }
}
