package com.example.java.chapters.h13;

import com.example.java.chapters.h10.*;

import java.util.LinkedList;
import java.util.List;

public class UnHouse {
    public UnHouse() {
        List<Object> objectList = new LinkedList<>(List.of("Bob", new Employee("Bob"), new char[]{'B', 'o', 'b'}));
        List<Employee> employeeList = new LinkedList<>(List.of(new Employee("Kim"), new Employee("Cynthia")));

        transferPerson(objectList, employeeList);

        System.out.println(objectList);
    }


    public void transferPerson(List<? super Person> to, List<? extends Person> from) {
        Person p = from.remove(from.size() - 1);
        to.add(p);
    }


    public static void main(String[] args) {
        new UnHouse();
    }
}
