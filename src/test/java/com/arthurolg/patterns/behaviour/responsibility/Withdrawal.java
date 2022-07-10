package com.arthurolg.patterns.behaviour.responsibility;

public class Withdrawal implements TransactionManager {
    private TransactionManager next;

    @Override
    public void setNextManager(TransactionManager next) {
        this.next = next;
    }

    @Override
    public void execute(Transaction transaction) {
        if (transaction.getTransactionType() == TransactionType.WITHDRAWAL) {
            float amount = transaction.getAmount() - transaction.getSubtotal();
            System.out.println("El nuevo balance después de un retiro es de: " + amount);
        } else {
            this.next.execute(transaction);
        }
    }
}
