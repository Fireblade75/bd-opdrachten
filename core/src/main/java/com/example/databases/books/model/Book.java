package com.example.databases.books.model;

import com.example.databases.books.exceptions.BookStoreException;

import java.util.Objects;

public class Book {
    private Integer id = null;
    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book$" + id + "{" +
                "title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
