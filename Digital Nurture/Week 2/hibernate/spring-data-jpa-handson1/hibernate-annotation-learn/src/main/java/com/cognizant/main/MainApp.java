package com.cognizant.main;

import com.cognizant.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // INSERT
        Employee emp = new Employee();
        emp.setName("John");
        emp.setSalary(50000);
        session.persist(emp);

        // FETCH ALL
        List<Employee> list = session.createQuery("from Employee", Employee.class).list();
        System.out.println("All: " + list);

        // FETCH ONE (NEW METHOD)
        Employee e = session.find(Employee.class, emp.getId());
        System.out.println("Single: " + e);

        // DELETE
        session.remove(emp);

        tx.commit();

        session.close();
        factory.close();
    }
}