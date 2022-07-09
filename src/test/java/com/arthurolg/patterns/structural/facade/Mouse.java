package com.arthurolg.patterns.structural.facade;

import java.util.Objects;

public class Mouse implements Peripheral {
    private final String connector;
    private final Boolean isWifi;

    public Mouse(String connector) {
        this.connector = connector;
        String connectorLowerCase = connector.toLowerCase();
        this.isWifi = (Objects.equals(connectorLowerCase, "wifi") || Objects.equals(connectorLowerCase, "bluetooth"));
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
            System.out.println("Conectando por medio de inalámbrico " + this.connector);
        } else {
            System.out.println("Conectando por medio físico: " + this.getConector());
        }
    }
}
