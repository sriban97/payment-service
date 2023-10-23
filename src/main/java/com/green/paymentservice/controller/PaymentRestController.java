package com.green.paymentservice.controller;

import com.green.paymentservice.entity.Payment;
import com.green.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "Payment" ,path = "/payment")
public class PaymentRestController {

    @Autowired
    private Environment environment;

    @Autowired
    private PaymentRepository paymentRepository;


    @PostMapping(name = "Save Payment", path = "/save")
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        Payment payment1 = paymentRepository.save(payment);
        return new ResponseEntity<>(payment1, HttpStatus.OK);
    }

    @GetMapping(name = "Get Payment by ID ", path = "/getById")
    public ResponseEntity<Payment> getById(@RequestParam("id") Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }


}
