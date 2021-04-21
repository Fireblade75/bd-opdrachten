package com.example.office.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "access")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    @Embedded
    private Address address;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "workplaces")
    private Set<Employee> access;
}
