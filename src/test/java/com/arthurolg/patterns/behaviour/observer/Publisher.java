package com.arthurolg.patterns.behaviour.observer;

public interface Publisher {
    void addObserver(Subscriber subscriber);
    void notifySubscribers();
    void removeObserver();
}
