package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Before Advice
    @Before("execution(* com.library.BookService.*(..))")
    public void beforeMethod(JoinPoint jp) {
        System.out.println("Before method: " + jp.getSignature().getName());
    }

    // After Advice
    @After("execution(* com.library.BookService.*(..))")
    public void afterMethod(JoinPoint jp) {
        System.out.println("After method: " + jp.getSignature().getName());
    }
}