package com.green.paymentservice.util;

public interface Constant {
    interface Header {
        String SSO_ID = "sso-id";
    }
    interface Payment{
        String TOPIC_CREATE_PAYMENT = "create-payment";
        String GROUP_PAYMENT = "payment-group";
        String GROUP_PAYMENT_V1 = "payment-group-v1";
    }

}
