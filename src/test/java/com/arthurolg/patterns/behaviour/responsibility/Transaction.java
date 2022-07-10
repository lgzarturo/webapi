package com.arthurolg.patterns.behaviour.responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {
    private float amount;
    private float subtotal;
    private TransactionType transactionType;
}
