package com.arthurolg.patterns.structural.decorator;

public class Decorator {
    public static void main(String[] args) {
        SushiInterface sushiWithBeef = new BeefSushi(new RollSushi());
        System.out.println("Sushi: " + sushiWithBeef.description());
        System.out.println("Price: $ " + sushiWithBeef.price() + " MXN");
        SushiInterface avocado = new AvocadoSushi(sushiWithBeef);
        System.out.println("Sushi: " + avocado.description());
        System.out.println("Price: $ " + avocado.price() + " MXN");
        SushiInterface sushiWithoutBeef = new AvocadoSushi(new RollSushi());
        System.out.println("Sushi: " + sushiWithoutBeef.description());
        System.out.println("Price: $ " + sushiWithoutBeef.price() + " MXN");
    }
}
