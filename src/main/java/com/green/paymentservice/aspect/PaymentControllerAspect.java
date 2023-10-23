package com.green.paymentservice.aspect;


import com.green.paymentservice.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class PaymentControllerAspect {

    @Before(value = "execution(* com.green.paymentservice.controller.PaymentRestController.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("{} Being..", joinPoint.getSignature());
    }

    @After(value = "execution(* com.green.paymentservice.controller.PaymentRestController.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("{} End", joinPoint.getSignature());
    }

    @AfterThrowing(value = "execution(* com.green.paymentservice.controller.PaymentRestController.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.error("{} Exception {}", joinPoint.getSignature(), exception.getMessage());

    }

    @AfterReturning(value = "execution(* com.green.paymentservice.controller.PaymentRestController.*(..))", returning = "response")
    public void afterThrowing(JoinPoint joinPoint, ResponseEntity<Payment> response) {
        log.info("{} Response send Status {} Body {}", joinPoint.getSignature(), response.getStatusCode(),response.getBody());

    }
}
