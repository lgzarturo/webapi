package com.arthurolg.patterns.structural.facade;

public class Keyboard implements Peripheral {

    private String connector;
    private Boolean isWifi;

    public Keyboard(Boolean isWifi) {
        this.isWifi = isWifi;
        this.connector = (isWifi) ? "Dongle USB" : "USB";
    }

    @Override
    public String getConector() {
        return this.connector;
    }

    @Override
    public Boolean isWired() {
        return !this.isWifi;
    }

    @Override
    public void linking() {
        if (this.isWifi) {
            System.out.println("Conectando por medio de wifi");
        } else {
            System.out.println("Conectando por medio físico con " + this.getConector());
        }
    }
}
