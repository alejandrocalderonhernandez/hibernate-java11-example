package com.alejandro.util;

import com.alejandro.model.entity.EmployeeEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateHelperFromProperties {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Properties properties= new Properties();
        try {
            properties.load(new FileInputStream(new File("src/main/resources/hibernate.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new Configuration().mergeProperties(properties)
                    .addAnnotatedClass(EmployeeEntity.class)
                    .buildSessionFactory();

        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}
