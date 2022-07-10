package com.arthurolg.patterns.behaviour.visitor;

public interface Discount {
    float apply(Fruit fruit);
    float apply(Device device);
}
