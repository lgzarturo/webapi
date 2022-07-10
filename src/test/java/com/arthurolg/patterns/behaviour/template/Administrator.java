package com.arthurolg.patterns.behaviour.template;

public class Administrator extends User {
    @Override
    void working() {
        System.out.println("Aquí trabaja un administrador");
    }
}
