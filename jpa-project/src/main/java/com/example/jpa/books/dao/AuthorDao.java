package com.example.jpa.books.dao;

import com.example.jpa.books.model.AuthorEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public enum AuthorDao {

    INSTANCE;

    public static final EntityManager em =
            Persistence.createEntityManagerFactory("bookstore").createEntityManager();

    public AuthorEntity get(int id) {
        var query = em.createQuery("SELECT a FROM AuthorEntity a WHERE a.authorId = ?1", AuthorEntity.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    public List<AuthorEntity> getAll() {
        var query = em.createQuery("SELECT a FROM AuthorEntity  a", AuthorEntity.class);
        return query.getResultList();
    }

    public void saveAuthor(AuthorEntity authorEntity) {
        em.getTransaction().begin();
        em.persist(authorEntity);
        em.getTransaction().commit();
    }
}
