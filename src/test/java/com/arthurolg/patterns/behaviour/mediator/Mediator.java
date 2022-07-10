package com.arthurolg.patterns.behaviour.mediator;

public class Mediator {
    public static void main(String[] args) {
        Person person1 = new Person("Arturo");
        Person person2 = new Person("John");

        RoomChat room = new RoomChat();
        room.add(person1);
        room.add(person2);
        room.sendMessage(person1, person2, "Hello from mediator pattern");
    }
}
