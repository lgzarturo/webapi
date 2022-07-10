package com.arthurolg.patterns.behaviour.visitor;

public class Microwave implements Device, DiscountApplied {
    @Override
    public float getPrice() {
        return 1500f;
    }

    @Override
    public float applyDiscount(Discount discount) {
        return this.getPrice() - discount.apply(this);
    }
}
