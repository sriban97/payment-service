package com.green.paymentservice.controller;

import com.green.paymentservice.entity.Payment;
import com.green.paymentservice.repository.PaymentRepository;
import com.green.paymentservice.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "Payment", path = "/payment")
@Slf4j
public class PaymentRestController {
    @Autowired
    private Environment environment;
    @Autowired
    private PaymentRepository paymentRepository;


    @PostMapping(name = "Save Payment", path = "/save")
    public ResponseEntity<Payment> save(@RequestBody Payment payment, @RequestHeader HttpHeaders headers) {
        var LOG_NAME = "save";
        var SSO = headers.getOrEmpty(Constant.Header.SSO_ID);

        log.info("{} SSO {} Begin...", LOG_NAME, SSO);

        Payment payment1 = paymentRepository.save(payment);
        log.info("{} payment1 {}", LOG_NAME, payment1);

        log.info("{} SSO {} End.", LOG_NAME, SSO);
        return new ResponseEntity<>(payment1, HttpStatus.OK);
    }

    @GetMapping(name = "Get Payment by ID ", path = "/getById")
    public ResponseEntity<Payment> getById(@RequestParam("id") Long id, @RequestHeader HttpHeaders headers) {
        var LOG_NAME = "save";
        var SSO = headers.getOrEmpty(Constant.Header.SSO_ID);

        log.info("{} SSO {} Begin...", LOG_NAME, SSO);

        Payment payment = paymentRepository.findById(id).orElse(null);
        log.info("{} payment {} ", LOG_NAME, payment);

        log.info("{} SSO {} End.", LOG_NAME, SSO);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }


}
