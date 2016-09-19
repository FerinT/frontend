package com.taylor.ferin.frontend.domain.transaction;

import java.util.Map;

/**
 * Created by Ferin on 2016-08-28.
 */
public abstract class Transaction {
    public Transaction nextTransaction;

    public void setNextTransaction(Transaction nextTransaction){
        this.nextTransaction = nextTransaction;
    }

    public abstract Transaction handleRequest(String request);
    public abstract boolean performTransaction(Map<String, Object> data);
}
