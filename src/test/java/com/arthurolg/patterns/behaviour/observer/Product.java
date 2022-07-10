package com.arthurolg.patterns.behaviour.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class Product implements Publisher {

    private Set<Subscriber> subscribers;
    private int quantity;

    public Product(int quantity) {
        this.subscribers = new LinkedHashSet<>();
        this.quantity = quantity;
    }

    public void sell() {
        this.setQuantity(this.quantity - 1);
        System.out.println("Se ha vendido un producto");
        this.notifySubscribers();
    }

    @Override
    public void addObserver(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber: this.subscribers) {
            subscriber.notification();
        }
    }

    @Override
    public void removeObserver() {

    }
}
