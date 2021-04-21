package com.example.office.dao;

import com.example.office.model.Employee;

import java.util.Optional;

public class EmployeeDao extends BaseDao<Employee> {
    public Optional<Employee> findByName(String name) {
        String sql = "SELECT e FROM Employee e WHERE lower(e.name) = ?1";
        var employeeList = em.createQuery(sql,Employee.class )
                .setParameter(1, name.toLowerCase())
                .setMaxResults(1)
                .getResultList();

        if(employeeList.size() == 1) {
            Employee employee = employeeList.get(0);
            em.detach(employee);
            return Optional.of(employee);
        } else {
            return Optional.empty();
        }
    }
}
