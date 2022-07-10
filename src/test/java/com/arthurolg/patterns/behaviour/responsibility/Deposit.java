package com.arthurolg.patterns.behaviour.responsibility;

public class Deposit implements TransactionManager  {

    private TransactionManager next;

    @Override
    public void setNextManager(TransactionManager next) {
        this.next = next;
    }

    @Override
    public void execute(Transaction transaction) {
        if (transaction.getTransactionType() == TransactionType.DEPOSIT) {
            float amount = transaction.getAmount() + transaction.getSubtotal();
            System.out.println("El nuevo balance después de un deposito es de: " + amount);
        } else {
            this.next.execute(transaction);
        }
    }
}
