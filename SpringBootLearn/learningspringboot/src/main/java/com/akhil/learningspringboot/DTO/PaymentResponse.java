package com.akhil.learningspringboot.DTO;

public record PaymentResponse(long id, double amount, String currency, String email) {
}
