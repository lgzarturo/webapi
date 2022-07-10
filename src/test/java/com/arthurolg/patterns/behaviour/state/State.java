package com.arthurolg.patterns.behaviour.state;

public class State {
    public static void main(String[] args) {
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.startUp();
        System.out.println("\n");
        motorcycle.brakeOff();
        System.out.println("\n");
        motorcycle.brakeOn();
        System.out.println("\n");
        motorcycle.shutDown();
        System.out.println("\n");
        motorcycle.brakeOff();
    }
}
