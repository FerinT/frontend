package com.taylor.ferin.frontend.domain.transaction.impl;

import com.taylor.ferin.frontend.domain.account.Account;
import com.taylor.ferin.frontend.domain.transaction.Transaction;

import java.util.Map;

/**
 * Created by Ferin on 2016-08-28.
 */
public class Withdraw extends Transaction {

    public Withdraw(){}

    @Override
    public boolean performTransaction(Map<String, Object> data) {
        // call the update account service here
        double amount = Double.parseDouble(data.get("amount").toString());
        Account account = (Account) data.get("account");

        System.out.println("preparing to withdraw R" + amount + " from account " + account.getAccountNumber());
        return amount != 0;
    }

    @Override
    public Transaction handleRequest(String request) {
        if(request.equalsIgnoreCase("withdraw")){
            return new Withdraw();
        }
        else{
            if(nextTransaction != null){
                return nextTransaction.handleRequest(request);
            }
        }
        return null;
    }
}
