package com.arthurolg.patterns.structural.proxy;

public class Proxy {
    public static void main(String[] args) {
        System.out.println("Service Proxy");
        ServiceInterface service = new ProxyService(new Service(), new User("admin", false));
        service.create();
        service.read();
        service.update();
        service.delete();

        System.out.println("\nService Virtual Proxy");
        ServiceInterface virtual = new VirtualProxyService(new User("admin", false));
        virtual.create();
        virtual.read();
        virtual.update();
        virtual.delete();
    }
}
