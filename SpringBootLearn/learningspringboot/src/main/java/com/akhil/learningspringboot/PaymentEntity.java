package com.akhil.learningspringboot;

public record PaymentEntity(long id, double paymentAmount, String paymentCurrency, String userEmail) {
}
