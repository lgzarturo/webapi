package com.arthurolg.patterns.behaviour.responsibility;

public interface TransactionManager {
    void setNextManager(TransactionManager next);
    void execute(Transaction transaction);
}
