package com.example.office.actions.employee;

import com.example.office.actions.core.MenuAction;
import com.example.office.dao.EmployeeDao;
import com.example.office.model.Employee;
import com.example.office.model.Gender;
import com.example.office.view.EntityWindow;

import javax.inject.Inject;
import java.time.LocalDate;

public class AddEmployeeAction extends MenuAction {

    @Inject
    EmployeeDao employeeDao;

    @Inject
    EntityWindow window;

    @Override
    public void runAction() {
        String name = window.askForString("Give a name");
        LocalDate birthdate = window.askForDate("Give a birthdate");
        Gender gender = window.askForEnumValue(Gender.values(), "Give a gender");

        Employee employee = Employee.builder()
                .name(name)
                .birthdate(birthdate)
                .gender(gender)
                .build();

        employeeDao.save(employee);
    }

    @Override
    public String getActionName() {
        return "Add employee";
    }
}
