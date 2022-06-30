package com.arthurolg.patterns.structural.decorator;

public class BeefSushi implements SushiInterface {

    private final SushiInterface sushi;

    public BeefSushi(SushiInterface sushi) {
        this.sushi = sushi;
    }

    @Override
    public String description() {
        return this.sushi.description() + " carne adicional";
    }

    @Override
    public float price() {
        return this.sushi.price() + 14;
    }
}
