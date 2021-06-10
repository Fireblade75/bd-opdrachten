package com.example.java.overig.annotations;

import java.util.Arrays;
import java.util.List;

public class RolesTest {
    public static void main(String[] args) {

        EmployeeBuilder.Employee admin =  EmployeeBuilder.buildEmployee(EmployeeType.ADMINISTRATOR);
        EmployeeBuilder.Employee salesEmployee =  EmployeeBuilder.buildEmployee(EmployeeType.SALES);
        EmployeeBuilder.Employee prodEmployee =  EmployeeBuilder.buildEmployee(EmployeeType.PRODUCTION);
        EmployeeBuilder.Employee manager =  EmployeeBuilder.buildEmployee(EmployeeType.MANAGER);

        var employees = List.of(admin, salesEmployee, prodEmployee, manager);

        for(var employee: employees) {
            System.out.println(employee.getClass().getSimpleName());
            var roles = employee.getClass().getAnnotationsByType(Role.class);
            Arrays.stream(roles).forEach(System.out::println);

            var rolesAnnotation = employee.getClass().getAnnotation(Roles.class);
            System.out.println(rolesAnnotation != null ? "Roles: " + rolesAnnotation.toString() : "no roles");
            System.out.println(employee.getClass().getAnnotation(Role.class) != null
                    ? "Value: " +  employee.getClass().getAnnotation(Role.class).value()
                    : "Value: null");
            System.out.println("\n\n");

        }
    }
}
