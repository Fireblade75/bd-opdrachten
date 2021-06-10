package com.example.office.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@NoArgsConstructor
@DiscriminatorValue(value = "manager")
public class Manager extends Employee {

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public Manager(Employee employee) {
        super(employee.getId(), employee.getName(), employee.getGender(), employee.getBirthdate(), employee.getWorkplaces());
        this.employees = new HashSet<>();
    }

    @Override
    public String getJobTitle() {
        return "manager";
    }

    public void assignEmployee(Employee employee) {
        employees.add(employee);
    }

    public String toManagerTable() {
        StringJoiner sj = new StringJoiner("\n- ");
        sj.add(getName());
        employees.forEach(e -> sj.add(e.toString()));
        return sj.toString();
    }
}
