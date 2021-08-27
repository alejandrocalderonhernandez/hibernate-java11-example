package com.alejandro.dao;

import com.alejandro.util.HibernateHelperFromProperties;
import org.hibernate.Session;

import java.io.Serializable;

public class AbstractCrudDao<E extends Serializable, ID> {

    protected  Session session;
    protected AbstractCrudDao() {
        this.session = HibernateHelperFromProperties.getSessionFactory().openSession();
    }

    public E save(E entity) {
        session.beginTransaction();
        this.session.save(entity);
        session.getTransaction().commit();
        HibernateHelperFromProperties.shutdown();
        return entity;
    }
}
