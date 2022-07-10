package com.arthurolg.patterns.behaviour.strategy;

public class Investment {
    private OperationInterface operation;

    public Investment(OperationInterface operation) {
        this.operation = operation;
    }

    public float execute(float balance, float amount) {
        return this.operation.execute(balance, amount);
    }
}
