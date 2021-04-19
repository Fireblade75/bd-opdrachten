package com.example.jpa.books.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books", schema = "bookstore")
public class BookEntity {
    private int bookId;
    private String title;
    private AuthorEntity author;

    @Id
    @Column(name = "book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToOne
    @JoinColumn(name = "author_id", nullable = true)
    public AuthorEntity getAuthor() { return author; }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return title + "- " + author.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bookId == that.bookId && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title);
    }
}
