package com.arthurolg.patterns.behaviour.strategy;

public class Strategy {
    public static void main(String[] args) {
        Investment addFunds = new Investment(new AddInvestmentFunds());
        System.out.println(addFunds.execute(1000, 200));
        Investment removeFunds = new Investment(new RemoveInvestmentFunds());
        System.out.println(removeFunds.execute(1000, 200));
    }
}
