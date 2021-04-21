package com.example.office.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private int houseNumber;
    private String zipcode;
    private String city;
}
