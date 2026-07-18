package com.library;

import org.springframework.stereotype.Component;

@Component
public class BookService {

    public void showBook() {
        System.out.println("Executing BookService method...");
    }
}