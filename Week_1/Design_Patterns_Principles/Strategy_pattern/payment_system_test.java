package com.example.strategypattern;

public class PaymentSystemTest {
    public static void main(String[] args) {
        // Create a payment context
        PaymentContext paymentContext = new PaymentContext();

        // Set the payment strategy to Credit Card and pay
        paymentContext.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "John Doe", "123"));
        paymentContext.pay(100.00);

        System.out.println();

        // Set the payment strategy to PayPal and pay
        paymentContext.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        paymentContext.pay(200.00);
    }
}
