package com.arthurolg.patterns.behaviour.strategy;

public class AddInvestmentFunds implements OperationInterface {
    @Override
    public float execute(float balance, float amount) {
        return balance + amount;
    }
}
