package com.alejandro;

import com.alejandro.dao.EmployeeDao;
import com.alejandro.model.entity.EmployeeEntity;

public class Main {

    public static void main(String... args) {

        EmployeeDao dao = new EmployeeDao();

        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("my-test@mail.com");
        emp.setFirstName("test");
        emp.setLastName("user");
        System.out.println(dao.save(emp));


    }
}
