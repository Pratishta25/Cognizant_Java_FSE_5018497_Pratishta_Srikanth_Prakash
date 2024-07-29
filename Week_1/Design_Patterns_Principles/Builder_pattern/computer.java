package com.example.builderpattern;

public class Computer {
    // Required attributes
    private String CPU;
    private String RAM;
    private String storage;

    // Optional attributes
    private boolean hasGraphicsCard;
    private boolean hasBluetooth;
    private boolean hasWiFi;

    // Private constructor to prevent direct instantiation
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWiFi = builder.hasWiFi;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage +
                ", hasGraphicsCard=" + hasGraphicsCard + ", hasBluetooth=" + hasBluetooth +
                ", hasWiFi=" + hasWiFi + "]";
    }

    // Static nested Builder class
    public static class Builder {
        // Required attributes
        private String CPU;
        private String RAM;
        private String storage;

        // Optional attributes
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;
        private boolean hasWiFi;

        // Constructor for required attributes
        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        // Methods for optional attributes
        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Builder setWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        // Build method to return an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}
