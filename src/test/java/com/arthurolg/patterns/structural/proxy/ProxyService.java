package com.arthurolg.patterns.structural.proxy;

public class ProxyService implements ServiceInterface {

    private final ServiceInterface service;
    private final User user;

    public ProxyService(ServiceInterface service, User user) {
        this.service = service;
        this.user = user;
    }

    @Override
    public void create() {
        if (user.isAdmin) {
            service.create();
        }
    }

    @Override
    public void read() {
        service.read();
    }

    @Override
    public void update() {
        if (user.isAdmin) {
            service.update();
        }
    }

    @Override
    public void delete() {
        if (user.isAdmin) {
            service.delete();
        }
    }
}
