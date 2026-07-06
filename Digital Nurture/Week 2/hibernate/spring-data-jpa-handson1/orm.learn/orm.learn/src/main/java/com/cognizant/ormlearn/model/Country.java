package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name="country")
public class Country {

    @Id
    @Column(name="co_code")
    private String code;

    @Column(name="co_name")
    private String name;

    // getters and setters

    @Override
    public String toString() {
        return "Country{" + code + ", " + name + "}";
    }
}