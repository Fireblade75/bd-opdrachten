package com.example.jpa.books.dao;

import com.example.jpa.books.model.AuthorEntity;
import com.example.jpa.books.model.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public enum BookDao {

    INSTANCE;

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("bookstore").createEntityManager();

    public List<BookEntity> getByAuthor(AuthorEntity author) {
        var query = em.createQuery("SELECT b FROM BookEntity b WHERE b.author = ?1", BookEntity.class);
        query.setParameter(1, author);
        return query.getResultList();
    }

}
