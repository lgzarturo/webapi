package com.arthurolg.patterns.behaviour.command;

public class OnDevice implements CommandInterface {

    private final Device device;

    public OnDevice(Device device) {
        this.device = device;
    }

    @Override
    public void operation() {
        this.device.on();
    }
}
