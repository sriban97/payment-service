package com.green.paymentservice.repository;


import com.green.paymentservice.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Long> {
}
