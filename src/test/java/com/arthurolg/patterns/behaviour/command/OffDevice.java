package com.arthurolg.patterns.behaviour.command;

public class OffDevice implements CommandInterface {

    private final Device device;

    public OffDevice(Device device) {
        this.device = device;
    }

    @Override
    public void operation() {
        this.device.off();
    }
}
