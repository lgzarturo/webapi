package com.arthurolg.patterns.behaviour.visitor;

public class Visitor {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();
        Microwave microwave = new Microwave();

        Discount discount = new CommonDiscount();

        System.out.println("Costo de la Manzana " + apple.getPrice() + " descuento: " + apple.applyDiscount(discount));
        System.out.println("Costo de la Naranja " + orange.getPrice());
        System.out.println("Costo del Micro ondas " + microwave.getPrice() + " descuento: " + microwave.applyDiscount(discount));

    }
}
