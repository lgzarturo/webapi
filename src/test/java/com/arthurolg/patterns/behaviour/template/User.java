package com.arthurolg.patterns.behaviour.template;

public abstract class User {
    public void auth() {
        System.out.println("Todos los usuarios necesitan autenticación");
    }

    abstract void working();
}
