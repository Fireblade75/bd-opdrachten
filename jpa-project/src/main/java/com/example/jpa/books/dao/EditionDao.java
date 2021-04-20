package com.example.jpa.books.dao;

import com.example.jpa.books.model.BookEditionEntity;
import com.example.jpa.books.model.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class EditionDao {

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("bookstore").createEntityManager();

    public List<BookEditionEntity> getByBook(BookEntity book) {
        var query = em.createQuery("SELECT b FROM BookEditionEntity b WHERE b.book = ?1", BookEditionEntity.class);
        query.setParameter(1, book);
        return query.getResultList();
    }

}
