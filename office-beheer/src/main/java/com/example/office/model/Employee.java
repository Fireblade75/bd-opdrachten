package com.example.office.model;

import com.example.office.util.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(exclude = "workplaces")
@DiscriminatorColumn
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Gender gender;

    @Convert(converter = LocalDateConverter.class)
    @Column(nullable = false)
    private LocalDate birthdate;

    @ManyToMany
    private Set<Building> workplaces;

    public long getAge() {
        return ChronoUnit.YEARS.between(birthdate, LocalDate.now(ZoneId.of("Europe/Paris")));
    }

    public String getJobTitle() {
        return "employee";
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-7s | %-10s | %-3d years old",
                name, gender.toString().toLowerCase(), getJobTitle(), getAge());
    }
}
