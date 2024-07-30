package com.builder.pattern;

public class ComputerBuilderTest {
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB", "1TB SSD")
                .setGraphicsCard(true)
                .setWiFi(true)
                .build();

        Computer officeComputer = new Computer.Builder("Intel i5", "16GB", "512GB SSD")
                .setWiFi(true)
                .build();

        Computer basicComputer = new Computer.Builder("Intel i3", "8GB", "256GB SSD")
                .build();

        // Print the configurations
        System.out.println(gamingComputer);
        System.out.println(officeComputer);
        System.out.println(basicComputer);
    }
}
