package com.arthurolg.patterns.creational;

public class SimpleFactory {
    public static void main(String[] args) {
        var pizza = new PizzaFactory();
        var smallPizza = pizza.createPizzaSmall();
        System.out.println(smallPizza);
        var normalPizza = pizza.createPizzaNormal();
        System.out.println(normalPizza);
        var bigPizza = pizza.createPizzaBig();
        System.out.println(bigPizza);
    }
}

class PizzaFactory {
    public Pizza createPizzaSmall() {
        return new Pizza(6);
    }
    public Pizza createPizzaNormal() {
        return new Pizza(8);
    }
    public Pizza createPizzaBig() {
        return new Pizza(12);
    }

}

class Pizza {
    private final int slices;

    public Pizza(int slices) {
        this.slices = slices;
    }

    @Override
    public String toString() {
        return "Pizza de "+this.slices+" rebanadas";
    }
}
