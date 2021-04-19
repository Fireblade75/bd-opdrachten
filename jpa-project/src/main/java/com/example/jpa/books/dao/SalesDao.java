package com.example.jpa.books.dao;

import com.example.jpa.books.model.BookEditionEntity;
import com.example.jpa.books.model.SalesEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public enum SalesDao {

    INSTANCE;

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("bookstore").createEntityManager();

    public void addSale(BookEditionEntity bookEdition) {
        SalesEntity sale = new SalesEntity();
        sale.setBookEdition(bookEdition);

        em.getTransaction().begin();
        em.persist(sale);
        em.getTransaction().commit();
    }
}
