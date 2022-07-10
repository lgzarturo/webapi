package com.arthurolg.patterns.behaviour.iterator;

import java.util.ArrayList;

public class PhoneGuide {
    private final ArrayList<String> phones;

    public PhoneGuide() {
        this.phones = new ArrayList<>();
    }

    public void add(String phone) {
        this.phones.add(phone);
    }

    public ArrayList<String> getPhones() {
        return this.phones;
    }
}
