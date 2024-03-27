package com.green.paymentservice.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.paymentservice.entity.Payment;
import com.green.paymentservice.repository.PaymentRepository;
import com.green.paymentservice.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentConsumer {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PaymentRepository paymentRepository;

    @KafkaListener(groupId = Constant.Payment.GROUP_PAYMENT, topics = Constant.Payment.TOPIC_CREATE_PAYMENT)
    public void paymentReceiver(String request) {
        var LOG_NAME = "paymentReceiver";

        log.info("{} Begin...", LOG_NAME);
        log.info("{} request {}", LOG_NAME, request);
        try {
            Payment payment = objectMapper.readValue(request, Payment.class);
            log.info("{} payment {}", LOG_NAME, payment);
            Payment savedPayment = paymentRepository.save(payment);
            log.info("{} savedPayment {}", LOG_NAME, savedPayment);
        } catch (Exception e) {
            log.error("{} error {}", LOG_NAME, e.getMessage());
        }

        log.info("{}End.", LOG_NAME);
    }
}
