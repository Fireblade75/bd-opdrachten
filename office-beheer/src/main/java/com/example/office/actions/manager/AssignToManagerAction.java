package com.example.office.actions.manager;

import com.example.office.actions.core.MenuAction;
import com.example.office.dao.EmployeeDao;
import com.example.office.dao.ManagerDao;
import com.example.office.model.Employee;
import com.example.office.model.Manager;
import com.example.office.view.EntityWindow;

import javax.inject.Inject;
import java.util.Optional;

public class AssignToManagerAction extends MenuAction {

    @Inject
    EmployeeDao employeeDao;

    @Inject
    ManagerDao managerDao;

    @Inject
    EntityWindow window;

    @Override
    public void runAction() {
        String employeeName = window.askForString("Give the name of the employee to assign");
        Optional<Employee> optionalEmployee = employeeDao.findByName(employeeName);

        if(optionalEmployee.isEmpty()) {
            window.displayLine("Err: Employee not found");
            return;
        }

        Employee employee = optionalEmployee.get();
        if(employee instanceof Manager) {
            window.displayLine("Err: Can't assign a manager to another manager");
            return;
        }

        String managerName = window.askForString("Give the name of the manager");
        Optional<Manager> optionalManager = managerDao.findByName(managerName);

        if(optionalManager.isEmpty()) {
            window.displayLine("Err: Manager not found");
            return;
        }

        Manager manager = optionalManager.get();
        managerDao.assignEmployeeToManager(manager, employee);
        managerDao.save(manager);

        window.displayEntity(manager, "Assigned employee to manager");
    }

    @Override
    public int priority() {
        return -5;
    }

    @Override
    public String getActionName() {
        return "Assign to manager";
    }
}

