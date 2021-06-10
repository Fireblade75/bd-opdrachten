package com.example.office.dao;

import com.example.office.model.Employee;
import com.example.office.model.Manager;

import javax.inject.Inject;
import java.util.Optional;

public class ManagerDao extends BaseDao<Manager> {

    @Inject
    protected EmployeeDao employeeDao;

    /**
     * Promotes an employee to a manager
     * @param id the id employee to promote
     * @return the new manager object or null if the employee was already a manager
     */
    public Manager promote(int id) {
        Manager manager = null;
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, id);
        if(!(employee instanceof Manager)) {
            manager = new Manager(employee);
            em.remove(employee);
            em.merge(manager);
        }
        em.getTransaction().commit();
        return manager;
    }

    public Optional<Manager> findByName(String name) {
        Optional<Employee> optionalEmployee = employeeDao.findByName(name);
        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            if(employee instanceof Manager) {
                return Optional.of((Manager) employee);
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public void assignEmployeeToManager(Manager detachedManager, Employee detachedEmployee) {
        em.getTransaction().begin();
        Manager manager = em.find(Manager.class, detachedManager.getId());
        Employee employee = em.find(Employee.class, detachedEmployee.getId());
        manager.assignEmployee(employee);
        em.persist(manager);
        em.getTransaction().commit();
    }
}
