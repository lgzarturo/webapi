package com.arthurolg.patterns.structural.decorator;

public class RollSushi implements SushiInterface {
    @Override
    public String description() {
        return "Roll de sushi";
    }

    @Override
    public float price() {
        return 100;
    }
}
