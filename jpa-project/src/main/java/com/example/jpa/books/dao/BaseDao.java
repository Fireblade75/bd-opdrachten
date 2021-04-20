package com.example.jpa.books.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDao<E> {

//    @PersistenceContext
//    protected static EntityManager em;

    protected static final EntityManager em =
            Persistence.createEntityManagerFactory("bookstore").createEntityManager();

    public E get(int id) {
        E e =  em.find(E(), id);
        em.detach(e);
        return e;
    }

    public List<E> getAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<E> cq = criteriaBuilder.createQuery(E());
        Root<E> rootEntry = cq.from(E());
        CriteriaQuery<E> all = cq.select(rootEntry);
        TypedQuery<E> allQuery = em.createQuery(all);

        List<E> results =  allQuery.getResultList();
        return detachList(results);
    }

    protected List<E> detachList(List<E> elements) {
        elements.forEach(em::detach);
        return elements;
    }

    public void save(E e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void update(E e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    private Class<E> E() {
        ParameterizedType thisDaoClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) thisDaoClass.getActualTypeArguments()[0];
    }
}
