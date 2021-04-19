package com.example.jpa.books.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sales", schema = "bookstore")
public class SalesEntity {
    private int saleId;
    private Timestamp saleDate;
    private BookEditionEntity bookEdition;

    @Id
    @Column(name = "sale_id", nullable = false)
    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    @Basic
    @Column(name = "sale_date", nullable = false, insertable = false)
    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    @OneToOne
    @JoinColumn(name = "edition_id", nullable = true)
    public BookEditionEntity getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(BookEditionEntity bookEdition) {
        this.bookEdition = bookEdition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesEntity that = (SalesEntity) o;
        return saleId == that.saleId && Objects.equals(saleDate, that.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, saleDate);
    }
}
