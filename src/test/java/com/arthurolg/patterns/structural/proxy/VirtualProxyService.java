package com.arthurolg.patterns.structural.proxy;

public class VirtualProxyService implements ServiceInterface {
    private ServiceInterface service;
    private final User user;

    public VirtualProxyService(User user) {
        this.user = user;
    }

    @Override
    public void create() {
        if (user.isAdmin) {
            this.getService().create();
        }
    }

    @Override
    public void read() {
        this.getService().read();
    }

    @Override
    public void update() {
        if (user.isAdmin) {
            this.getService().update();
        }
    }

    @Override
    public void delete() {
        if (user.isAdmin) {
            this.getService().delete();
        }
    }

    private ServiceInterface getService() {
        if (this.service == null) {
            this.service = new Service();
        }
        return this.service;
    }
}
