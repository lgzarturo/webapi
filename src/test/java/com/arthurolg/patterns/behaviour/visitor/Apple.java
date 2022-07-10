package com.arthurolg.patterns.behaviour.visitor;

public class Apple implements Fruit, DiscountApplied {
    @Override
    public float getPrice() {
        return 2f;
    }

    @Override
    public float applyDiscount(Discount discount) {
        return this.getPrice() - discount.apply(this);
    }
}
