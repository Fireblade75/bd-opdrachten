package com.example.jpa.books.dao;

import com.example.jpa.books.model.BookEditionEntity;
import com.example.jpa.books.model.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EditionDao extends BaseDao<BookEditionEntity> {

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("bookstore").createEntityManager();

    public List<BookEditionEntity> getByBook(BookEntity book) {
        var query = em.createQuery("SELECT b FROM BookEditionEntity b WHERE b.book = ?1", BookEditionEntity.class);
        query.setParameter(1, book);
        return detachList(query.getResultList());
    }

    public List<BookEditionEntity> getByValue(String value) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        // Maak de query en voeg de from toe
        CriteriaQuery<BookEditionEntity> cq = cb.createQuery(BookEditionEntity.class);
        Root<BookEditionEntity> from = cq.from(BookEditionEntity.class);

        cq.select(from).where();

        // Voer het request uit en geef het resultaat terug
        TypedQuery<BookEditionEntity> q = em.createQuery(cq);
        return q.getResultList();
    }
}
