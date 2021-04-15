package com.example.databases.books.model;

import com.example.databases.books.exceptions.BookStoreException;

import java.util.Date;
import java.util.Objects;

public class Author {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Gender sex;
    private Integer id = null;

    public Author(String firstName, String lastName, Date birthDate, Gender sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean hasId() {
        return id != null;
    }

    public int getId() {
        if(id == null) {
            throw new BookStoreException("Trying to get id from not persistent Author");
        }
        return id;
    }

    @Override
    public String toString() {
        return "Author$" + id + "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                '}';
    }

}
