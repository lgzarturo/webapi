package com.arthurolg.patterns.structural.proxy;

public class Proxy {
    public static void main(String[] args) {
        ServiceInterface service = new ProxyService(new Service(), new User("admin", false));
        service.create();
        service.read();
        service.update();
        service.delete();
    }
}
