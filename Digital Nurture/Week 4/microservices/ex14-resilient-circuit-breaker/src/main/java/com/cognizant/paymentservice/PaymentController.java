package com.cognizant.paymentservice;

import com.cognizant.paymentservice.service.ThirdPartyService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final ThirdPartyService thirdPartyService;

    public PaymentController(ThirdPartyService thirdPartyService) {
        this.thirdPartyService = thirdPartyService;
    }

    @GetMapping("/process")
    @CircuitBreaker(name = "paymentServiceCircuitBreaker", fallbackMethod = "fallbackProcess")
    public String processPayment() {
        thirdPartyService.simulateSlowService();
        return "Payment processed successfully";
    }

    public String fallbackProcess(Throwable t) {
        return "Fallback: Payment service is unavailable, please try again later";
    }
}
