package com.observer.pattern;

public class StockMarketTest {
    public static void main(String[] args) {
        // Create a stock market
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        // Register observers
        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        // Update stock price and notify observers
        stockMarket.setStockPrice(150.00);
        stockMarket.setStockPrice(155.00);

        // Deregister an observer and update stock price
        stockMarket.deregister(mobileApp);
        stockMarket.setStockPrice(160.00);
    }
}
