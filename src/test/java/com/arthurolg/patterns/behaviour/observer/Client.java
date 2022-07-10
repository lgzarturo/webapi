package com.arthurolg.patterns.behaviour.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client implements Subscriber {
    private String name;

    @Override
    public void notification() {
        System.out.println("Se ha recibido su compra");
    }
}
