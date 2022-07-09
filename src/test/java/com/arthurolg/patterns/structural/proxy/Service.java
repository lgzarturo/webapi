package com.arthurolg.patterns.structural.proxy;

public class Service implements ServiceInterface {
    @Override
    public void create() {
        System.out.println("Creando objeto");
    }

    @Override
    public void read() {
        System.out.println("Leyendo de la base");
    }

    @Override
    public void update() {
        System.out.println("Actualizando objeto");
    }

    @Override
    public void delete() {
        System.out.println("Borrando datos");
    }
}
