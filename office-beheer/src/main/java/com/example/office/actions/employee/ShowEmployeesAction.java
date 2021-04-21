package com.example.office.actions.employee;

import com.example.office.actions.core.MenuAction;
import com.example.office.dao.EmployeeDao;
import com.example.office.view.EntityWindow;

import javax.inject.Inject;

public class ShowEmployeesAction extends MenuAction {

    @Inject
    EmployeeDao employeeDao;

    @Inject
    EntityWindow window;

    @Override
    public void runAction() {
        var employees = employeeDao.getAll();
        window.displayEntities(employees, "List of employees");
    }

    @Override
    public String getActionName() {
        return "Show employees";
    }
}
