package com.example.jpa.books.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_awards", schema = "bookstore", catalog = "")
@IdClass(BookAwardsEntityPK.class)
public class BookAwardsEntity {
    private int awardId;
    private int bookId;

    @Id
    @Column(name = "award_id", nullable = false)
    public int getAwardId() {
        return awardId;
    }

    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAwardsEntity that = (BookAwardsEntity) o;
        return awardId == that.awardId && bookId == that.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardId, bookId);
    }
}
