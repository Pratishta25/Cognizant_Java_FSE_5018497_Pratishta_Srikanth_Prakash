package com.example.singleton;

public class LoggerTest {
    public static void main(String[] args) {
        // Get the instance of the Logger class
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages using the logger instances
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Verify that both logger1 and logger2 are the same instance
        if (logger1 == logger2) {
            System.out.println("logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
