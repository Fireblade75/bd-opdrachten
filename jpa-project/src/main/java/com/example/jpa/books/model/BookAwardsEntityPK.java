package com.example.jpa.books.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BookAwardsEntityPK implements Serializable {
    private int awardId;
    private int bookId;

    @Column(name = "award_id", nullable = false)
    @Id
    public int getAwardId() {
        return awardId;
    }

    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }

    @Column(name = "book_id", nullable = false)
    @Id
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
        BookAwardsEntityPK that = (BookAwardsEntityPK) o;
        return awardId == that.awardId && bookId == that.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardId, bookId);
    }
}
