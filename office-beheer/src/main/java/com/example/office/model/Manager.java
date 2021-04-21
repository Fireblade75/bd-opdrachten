package com.example.office.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "manager")
public class Manager extends Employee {

    @OneToMany
    private Set<Employee> employees;

    @Override
    public String getJobTitle() {
        return "manager";
    }
}
