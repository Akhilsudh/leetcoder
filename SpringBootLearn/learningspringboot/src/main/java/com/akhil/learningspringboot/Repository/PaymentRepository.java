package com.akhil.learningspringboot.Repository;

import com.akhil.learningspringboot.DTO.PaymentRequest;
import com.akhil.learningspringboot.PaymentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

    public PaymentEntity getPaymentById(PaymentRequest request) {
        return executeQuery(request);
    }

    private PaymentEntity executeQuery(PaymentRequest request) {
        // MOCK DB CALL
        return new PaymentEntity(request.getPayementId(), 100.00, "INR", "user@email.com");
    }
}
