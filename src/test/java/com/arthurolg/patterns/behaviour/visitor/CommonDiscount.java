package com.arthurolg.patterns.behaviour.visitor;

public class CommonDiscount implements Discount {
    @Override
    public float apply(Fruit fruit) {
        return fruit.getPrice() * 0.02f;
    }

    @Override
    public float apply(Device device) {
        return device.getPrice() * 0.20f;
    }
}
