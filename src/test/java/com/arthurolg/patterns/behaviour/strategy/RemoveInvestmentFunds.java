package com.arthurolg.patterns.behaviour.strategy;

public class RemoveInvestmentFunds implements OperationInterface {
    @Override
    public float execute(float balance, float amount) {
        return balance - amount;
    }
}
