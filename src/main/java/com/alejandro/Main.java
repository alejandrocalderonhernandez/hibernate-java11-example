package com.alejandro;

import com.alejandro.model.entity.EmployeeEntity;
import com.alejandro.util.HibernateUtil;
import org.hibernate.Session;

public class Main {

    public static void main(String... args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");

        session.save(emp);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
