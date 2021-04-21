package com.example.office.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {
    @Id
    @GeneratedValue
    private int id;

    private String brand;

    private int buildYear;

    @Embedded
    private OperatingSystem operatingSystem;
}
