package com.example.jpa.books.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "book_editions", schema = "bookstore")
public class BookEditionEntity {
    private int editionId;
    private String editionLabel;
    private BigDecimal price;
    private BookEntity book;

    @Id
    @Column(name = "edition_id", nullable = false)
    public int getEditionId() {
        return editionId;
    }

    public void setEditionId(int editionId) {
        this.editionId = editionId;
    }

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    public BookEntity getBook() { return book; }

    public void setBook(BookEntity book) { this.book = book; }

    @Basic
    @Column(name = "edition_label", nullable = true, length = 20)
    public String getEditionLabel() {
        return editionLabel;
    }

    public void setEditionLabel(String editionLabel) {
        this.editionLabel = editionLabel;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
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
        BookEditionEntity that = (BookEditionEntity) o;
        return editionId == that.editionId && Objects.equals(editionLabel, that.editionLabel) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editionId, editionLabel, price);
    }

    @Override
    public String toString() {
        return editionLabel + " - $" + price;
    }
}
