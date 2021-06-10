package com.example.jpa.books.dao;

import com.example.jpa.books.model.BookEditionEntity;
import com.example.jpa.books.model.BookEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class EditionDao extends BaseDao<BookEditionEntity> {

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("bookstore").createEntityManager();

    public List<BookEditionEntity> getByBook(BookEntity book) {
        var query = em.createQuery("SELECT b FROM BookEditionEntity b WHERE b.book = ?1", BookEditionEntity.class);
        query.setParameter(1, book);
        return detachList(query.getResultList());
    }

    public List<BookEditionEntity> getByTitle(String title) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        // Maak de query en voeg de from toe
        CriteriaQuery<BookEditionEntity> cq = cb.createQuery(BookEditionEntity.class);

        // Selecteer de tabellen
        Root<BookEditionEntity> bookEntity = cq.from(BookEditionEntity.class);
        Join<BookEditionEntity, BookEntity> book = bookEntity.join("book");

        // Voeg de critera toe
        cq.where(cb.equal(book.get("title"), title));

        // Voer het request uit en geef het resultaat terug
        TypedQuery<BookEditionEntity> q = em.createQuery(cq);
        return q.getResultList();
    }

    public static void main(String[] args) {
        var dao = new EditionDao();
        var books = dao.getByTitle("De sluwe haatster");

        System.out.println(books.size());
        books.forEach(System.out::println);
    }
}
