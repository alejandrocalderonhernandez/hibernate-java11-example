package com.alejandro.dao;

import com.alejandro.util.HibernateHelperFromProperties;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudDao<E extends Serializable, ID> {

    protected Session session;
    protected Class<E> clazz;

    protected AbstractCrudDao(Class<E> clazz) {
        this.session = HibernateHelperFromProperties.getSessionFactory().openSession();
        this.clazz = clazz;
    }

    public E save(E entity) {
        session.beginTransaction();
        this.session.saveOrUpdate(entity);
        session.getTransaction().commit();
        return entity;
    }

    public Optional<E> findById(ID id) {
        return Optional.of((E) session.get(clazz, id));
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll() {
       return session.createQuery("FROM " + clazz.getCanonicalName()).getResultList();
    }

    public void delete(E entity) {
        session.beginTransaction();
        this.session.delete(entity);
        session.getTransaction().commit();
    }
}
