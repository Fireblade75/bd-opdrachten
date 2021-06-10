package com.example.java.overig.annotations;

public class EmployeeBuilder {

    @Role("management")
    @Role("sales")
    public static class Manager extends Employee { }

    @Roles(@Role("system"))
    public static class SysAdmin extends Employee { }

    @Role("sales")
    public static class SalesEmployee extends Employee { }

    @Role("production")
    @Roles({@Role("Bob"), @Role("Van")})
    public static class Employee { }

    public static Employee buildEmployee(EmployeeType employeeType) {
        switch (employeeType) {
            case MANAGER: return new Manager();
            case ADMINISTRATOR: return new SysAdmin();
            case SALES: return new SalesEmployee();
            case PRODUCTION: return new Employee();
            default: throw new UnsupportedOperationException();
        }
    }
}
