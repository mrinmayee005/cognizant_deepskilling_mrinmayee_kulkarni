package com.cognizant.main;

import com.cognizant.hibernate.HibernateExample;

public class MainApp {

    public static void main(String[] args) {


        HibernateExample.addEmployee();

        System.out.println("Spring Data JPA uses repository.save()");
    }
}