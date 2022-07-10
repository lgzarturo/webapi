package com.arthurolg.patterns.behaviour.responsibility;

public class Refund implements TransactionManager {
    private TransactionManager next;

    @Override
    public void setNextManager(TransactionManager next) {
        this.next = next;
    }

    @Override
    public void execute(Transaction transaction) {
        if (transaction.getTransactionType() == TransactionType.REFUND) {
            float amount = transaction.getAmount() + transaction.getSubtotal();
            System.out.println("El nuevo balance después de un rembolso es de: " + amount);
        } else {
            System.out.println("Operación no valida!");
        }
    }
}
