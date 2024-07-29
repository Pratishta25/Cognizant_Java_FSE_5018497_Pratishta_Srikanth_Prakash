package com.example.commandpattern;

public class HomeAutomationTest {
    public static void main(String[] args) {
        // Create a light
        Light livingRoomLight = new Light();

        // Create commands
        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        Command lightOffCommand = new LightOffCommand(livingRoomLight);

        // Create remote control and set commands
        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOnCommand);
        remote.pressButton();

        System.out.println();

        // Turn the light off
        remote.setCommand(lightOffCommand);
        remote.pressButton();
    }
}
