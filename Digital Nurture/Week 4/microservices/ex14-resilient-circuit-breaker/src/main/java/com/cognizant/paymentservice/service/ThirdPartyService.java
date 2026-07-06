package com.cognizant.paymentservice.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ThirdPartyService {

    private final Random random = new Random();

    public void simulateSlowService() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (random.nextBoolean()) {
            throw new RuntimeException("Third party service failed");
        }
    }
}
