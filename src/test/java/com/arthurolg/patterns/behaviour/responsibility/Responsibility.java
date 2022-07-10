package com.arthurolg.patterns.behaviour.responsibility;

public class Responsibility {
    public static void main(String[] args) {

        Transaction transaction = new Transaction(1000, 200, TransactionType.WITHDRAWAL);
        TransactionManager deposit = new Deposit();
        TransactionManager withdraw = new Withdrawal();
        TransactionManager refund = new Refund();

        deposit.setNextManager(withdraw);
        withdraw.setNextManager(refund);

        deposit.execute(transaction);
    }
}
