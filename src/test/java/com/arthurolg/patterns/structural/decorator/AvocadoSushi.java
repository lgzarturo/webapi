package com.arthurolg.patterns.structural.decorator;

public class AvocadoSushi implements SushiInterface {
    private final SushiInterface sushi;

    public AvocadoSushi(SushiInterface sushi) {
        this.sushi = sushi;
    }

    @Override
    public String description() {
        return this.sushi.description() + " con mucho aguacate";
    }

    @Override
    public float price() {
        return this.sushi.price() + 22;
    }
}
