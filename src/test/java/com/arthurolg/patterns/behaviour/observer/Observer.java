package com.arthurolg.patterns.behaviour.observer;

public class Observer {
    public static void main(String[] args) {
        Product avocado = new Product(100);
        Client client1 = new Client("John Doe");
        Client client2 = new Client("Johana Doe");
        avocado.addObserver(client1);
        avocado.addObserver(client2);
        avocado.sell();
    }
}
