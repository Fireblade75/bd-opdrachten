package com.example.jpa.books.dao;

import com.example.jpa.books.model.BookEditionEntity;
import com.example.jpa.books.model.SaleEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SaleDao extends BaseDao<SaleEntity> {
    public static final EntityManager em =
            Persistence.createEntityManagerFactory("bookstore").createEntityManager();

    public void addSale(BookEditionEntity bookEdition) {
        SaleEntity sale = new SaleEntity();
        sale.setBookEdition(bookEdition);

        em.getTransaction().begin();
        em.persist(sale);
        em.getTransaction().commit();
        em.refresh(sale);
        em.detach(sale);
    }

    public List<SaleEntity> getLastSales(int amount) {
        return em.createQuery(
                    "SELECT s FROM SaleEntity s ORDER BY s.saleDate DESC", SaleEntity.class)
                .setMaxResults(amount)
                .getResultStream()
                .peek(em::detach)
                .collect(Collectors.toList());
    }

    public Optional<SaleEntity> removeLastSale() {
        em.getTransaction().begin();
        var sale = em.createQuery(
                    "SELECT s FROM SaleEntity s ORDER BY s.saleDate DESC", SaleEntity.class)
                .setMaxResults(1)
                .getResultStream()
                .peek(em::remove)
                .findAny();
        em.getTransaction().commit();
        return sale;
    }
}
