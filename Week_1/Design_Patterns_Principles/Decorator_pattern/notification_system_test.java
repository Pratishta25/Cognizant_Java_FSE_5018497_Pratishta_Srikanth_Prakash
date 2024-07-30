package com.decorator.pattern;

public class NotificationSystemTest {
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate it with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate it with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notifications via all channels
        slackNotifier.send("Hello, this is a test notification!");
    }
}
