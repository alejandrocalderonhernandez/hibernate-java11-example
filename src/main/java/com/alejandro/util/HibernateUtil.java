package com.alejandro.util;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final String CONFIG_FILE_PATH = "src/main/resources/hibernate.cfg.xml";

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure(new File(CONFIG_FILE_PATH)).buildSessionFactory();

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