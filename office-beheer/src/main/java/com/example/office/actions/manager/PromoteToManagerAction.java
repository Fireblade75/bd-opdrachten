package com.example.office.actions.manager;

import com.example.office.actions.core.MenuAction;
import com.example.office.dao.EmployeeDao;
import com.example.office.dao.ManagerDao;
import com.example.office.model.Employee;
import com.example.office.model.Manager;
import com.example.office.view.EntityWindow;

import javax.inject.Inject;
import java.util.Optional;

public class PromoteToManagerAction extends MenuAction {

    @Inject
    EmployeeDao employeeDao;

    @Inject
    ManagerDao managerDao;

    @Inject
    EntityWindow window;

    @Override
    public void runAction() {
        String name = window.askForString("Give the name of the employee");
        Optional<Employee> employee = employeeDao.findByName(name);
        if(employee.isPresent()) {
            Manager manager = managerDao.promote(employee.get().getId());
            if(manager != null) {
                window.displayLine(manager.getName() + " is now a manager");
            } else {
                window.displayLine("Failed to promote " + name + " to manager, maybe this person is already a manager?");
            }
        } else {
            window.displayLine("Err: Employee not found");
        }
    }

    @Override
    public int priority() {
        return -5;
    }

    @Override
    public String getActionName() {
        return "Promote to manager";
    }
}
