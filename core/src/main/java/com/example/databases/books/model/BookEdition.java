package com.example.databases.books.model;

import com.example.databases.books.exceptions.BookStoreException;

import java.math.BigDecimal;
import java.util.Objects;

public class BookEdition {
    private Integer id = null;
    private Book book;
    private String label;
    private BigDecimal price;

    public BookEdition(Book book, String label, BigDecimal price) {
        this.book = book;
        this.label = label;
        this.price = price;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEdition that = (BookEdition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BookEdition$" + id +"{" +
                "id=" + id +
                ", book=" + book +
                ", label='" + label + '\'' +
                ", price=" + price +
                '}';
    }
}
