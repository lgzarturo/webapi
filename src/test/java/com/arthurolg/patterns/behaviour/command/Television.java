package com.arthurolg.patterns.behaviour.command;

public class Television implements Device {

    private boolean on;

    public Television() {
        this.on = false;
    }

    @Override
    public void on() {
        this.on = true;
        System.out.println("Se ha encendido la Television.");
    }

    @Override
    public void off() {
        this.on = false;
        System.out.println("La Television se apago.");
    }
}
