package com.arthurolg.patterns.behaviour.command;

public class Command {
    public static void main(String[] args) {
        Device tv = new Television();
        CommandInterface on = new OnDevice(tv);
        CommandInterface off = new OffDevice(tv);
        on.operation();
        off.operation();
    }
}
