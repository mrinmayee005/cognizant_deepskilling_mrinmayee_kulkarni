package com.cognizant.main;

import com.cognizant.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        Transaction tx = null;

        try {
            // Open Session
            session = factory.openSession();

            // Begin Transaction
            tx = session.beginTransaction();

            // 🔹 FETCH ALL
            List<Country> list = session
                    .createQuery("from Country", Country.class)
                    .getResultList();

            System.out.println("All Countries: " + list);

            // 🔹 INSERT
            Country c = new Country();
            c.setCode("UK");
            c.setName("United Kingdom");

            session.persist(c);

            // 🔹 FETCH ONE (UPDATED)
            Country one = session.find(Country.class, "IN");
            System.out.println("Single Country: " + one);

            // 🔹 DELETE
            session.remove(c);

            // Commit
            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();

        } finally {

            if (session != null) session.close();
            factory.close();
        }
    }
}