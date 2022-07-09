package com.arthurolg.patterns.structural.facade;

public class Facade {

    private Computer computer;

    public Facade() {
        Peripheral mouse = new Mouse("WiFi");
        Peripheral keyboard = new Keyboard(false);
        this.computer = new Computer(mouse, keyboard);
    }

    public void powerOn() {
        this.computer.startUp();
    }
}
