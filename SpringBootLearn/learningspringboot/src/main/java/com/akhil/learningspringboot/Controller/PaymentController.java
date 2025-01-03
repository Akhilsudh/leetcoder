package com.akhil.learningspringboot.Controller;

import com.akhil.learningspringboot.DTO.PaymentRequest;
import com.akhil.learningspringboot.DTO.PaymentResponse;
import com.akhil.learningspringboot.Service.PaymentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id) {
        PaymentRequest internalPaymentRequest = new PaymentRequest();
        internalPaymentRequest.setPayementId(id);

        PaymentResponse response = paymentService.getPaymentDetailsById(internalPaymentRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/id")
    public ResponseEntity<PaymentResponse> getPaymentByIdPathParam(@PathParam(value="id") Long id) {
        PaymentRequest internalPaymentRequest = new PaymentRequest();
        internalPaymentRequest.setPayementId(id);

        PaymentResponse response = paymentService.getPaymentDetailsById(internalPaymentRequest);
        return ResponseEntity.ok(response);
    }
}
