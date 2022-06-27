package com.arthurolg.patterns.creational;

public class AbstractFactory {
    public static void main(String[] args) {
        var store = new Store();
        Computer asus = store.createComputer();
        Tablet lenovo = store.createTablet();
    }
}

interface AbstractFactoryInterfaz {
    Computer createComputer();
    Tablet createTablet();
}

interface Computer {}

interface Tablet {}

class AsusComputer implements Computer {}
class LenovoTablet implements Tablet {}


class Store implements AbstractFactoryInterfaz {
    @Override
    public Computer createComputer() {
        return new AsusComputer();
    }

    @Override
    public Tablet createTablet() {
        return new LenovoTablet();
    }
}
