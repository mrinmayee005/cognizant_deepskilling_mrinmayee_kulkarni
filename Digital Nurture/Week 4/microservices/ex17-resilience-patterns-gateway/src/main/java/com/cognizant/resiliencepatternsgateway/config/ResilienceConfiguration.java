package com.cognizant.resiliencepatternsgateway.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResilienceConfiguration {

    @Bean
    public ReactiveResilience4JCircuitBreakerFactory defaultCustomizer() {
        ReactiveResilience4JCircuitBreakerFactory factory =
            new ReactiveResilience4JCircuitBreakerFactory(
                CircuitBreakerRegistry.ofDefaults(),
                TimeLimiterRegistry.ofDefaults());
        factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
            .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
            .timeLimiterConfig(TimeLimiterConfig.ofDefaults())
            .build());
        return factory;
    }
}
