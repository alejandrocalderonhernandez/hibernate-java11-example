package com.alejandro;

import com.alejandro.dao.EmployeeDao;
import com.alejandro.model.entity.EmployeeEntity;

public class Main {

    public static void main(String... args) {

        EmployeeDao dao = new EmployeeDao();

        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("mytest@mail.com");
        emp.setFirstName("test");
        emp.setLastName("user");

        EmployeeEntity emp2 = new EmployeeEntity();
        emp2.setEmail("my-test@mail.com");
        emp2.setFirstName("test2");
        emp2.setLastName("user2");

        System.out.println(dao.save(emp));
        System.out.println(dao.save(emp2));
        System.out.println(dao.findById(emp.getEmployeeId()).get());

        dao.findAll().forEach(r -> {
            System.out.print(r.toString());
            dao.delete(r);
        });

    }
}
