package com.example.adapterpattern;

public class PaymentProcessorTest {
    public static void main(String[] args) {
        // Create instances of the payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        // Create adapters for the payment gateways
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        PaymentProcessor squareAdapter = new SquareAdapter(square);

        // Process payments using the adapters
        payPalAdapter.processPayment(100.00);
        stripeAdapter.processPayment(200.00);
        squareAdapter.processPayment(300.00);
    }
}
