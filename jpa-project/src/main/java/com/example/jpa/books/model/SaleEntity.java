package com.example.jpa.books.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "sales", schema = "bookstore")
public class SaleEntity {
    private int saleId;
    private Timestamp saleDate;
    private BookEditionEntity bookEdition;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Id
    @Column(name = "sale_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @ManyToOne
    @JoinColumn(name = "edition_id", nullable = true)
    public BookEditionEntity getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(BookEditionEntity bookEdition) {
        this.bookEdition = bookEdition;
    }

    @Override
    public String toString() {
        ZonedDateTime saleTime = saleDate.toInstant().atZone(ZoneId.of("Europe/Paris"));
        return String.format("%s - $%s - %s",
                bookEdition.getBook().toString(),
                bookEdition.getPrice().toString(),
                saleTime.format(dateFormatter));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleEntity that = (SaleEntity) o;
        return saleId == that.saleId && Objects.equals(saleDate, that.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, saleDate);
    }
}
