package com.arthurolg.patterns.behaviour.mediator;

import java.util.HashMap;

public class RoomChat {

    private final HashMap<String, Person> people;

    public RoomChat() {
        this.people = new HashMap<>();
    }

    public void add(Person person) {
        this.people.put(person.getName(), person);
    }

    public void sendMessage(Person sender, Person receiver, String message) {
        if (this.people.get(sender.getName()) != null && this.people.get(receiver.getName()) != null) {
            message = "FROM: " + sender.getName() + " MESSAGE: " + message;
            receiver.receiveMessage(message);
        }
    }
}
