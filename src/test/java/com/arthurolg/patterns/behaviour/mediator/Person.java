package com.arthurolg.patterns.behaviour.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;

    public void receiveMessage(String message) {
        System.out.println("Message: ["+message+"]");
    }
}
