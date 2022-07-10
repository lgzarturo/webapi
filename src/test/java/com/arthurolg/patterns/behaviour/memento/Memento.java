package com.arthurolg.patterns.behaviour.memento;

public class Memento {
    public static void main(String[] args) {
        Car audi = new Car(4, 4,3, "GREEN");

        Car backupAudi = audi.getCar();

        System.out.println("Original Car");
        System.out.println(audi);

        audi.setColor("WHITE");

        System.out.println("\nCar after changes");
        System.out.println(audi);

        System.out.println("\nReset changes");
        audi.reset(backupAudi);
        System.out.println(audi);
    }
}
