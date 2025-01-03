package com.akhil.learningspringboot.Service;

import com.akhil.learningspringboot.DTO.PaymentRequest;
import com.akhil.learningspringboot.DTO.PaymentResponse;
import com.akhil.learningspringboot.PaymentEntity;
import com.akhil.learningspringboot.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj) {
        PaymentEntity payment = paymentRepository.getPaymentById(internalRequestObj);

        // MAP ENTITY TO RESPONSE DTO
        PaymentResponse response = mapModelToResponseDTO(payment);
        return response;
    }

    private PaymentResponse mapModelToResponseDTO(PaymentEntity payment) {
        return new PaymentResponse(payment.id(), payment.paymentAmount(), payment.paymentCurrency(), payment.userEmail());
    }
}
