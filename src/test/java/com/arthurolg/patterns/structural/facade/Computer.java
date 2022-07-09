package com.arthurolg.patterns.structural.facade;

public class Computer {
    private Peripheral mouse;
    private Peripheral keyboard;

    public Computer(Peripheral mouse, Peripheral keyboard) {
        this.mouse = mouse;
        this.keyboard = keyboard;
    }

    public void startUp() {
        this.keyboard.linking();
        if (this.keyboard.isWired()) {
            System.out.println("La interfaz común es por medio de USB 3.0");
        }
        this.mouse.linking();
    }
}
