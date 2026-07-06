package com.library;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void displayBook() {
        System.out.println("Book data from repository (Annotation)");
    }
}