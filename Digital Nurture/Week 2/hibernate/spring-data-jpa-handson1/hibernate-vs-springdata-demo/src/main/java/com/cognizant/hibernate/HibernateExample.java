package com.cognizant.hibernate;

import com.cognizant.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void addEmployee() {

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee emp = new Employee();
            emp.setName("Mrinmayee");
            emp.setSalary(50000);

            session.persist(emp);   // instead of save()

            tx.commit();
            System.out.println("Hibernate Insert Done");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}