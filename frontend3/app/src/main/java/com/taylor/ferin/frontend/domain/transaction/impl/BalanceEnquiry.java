package com.taylor.ferin.frontend.domain.transaction.impl;

import com.taylor.ferin.frontend.domain.account.Account;
import com.taylor.ferin.frontend.domain.transaction.Transaction;

import java.util.Map;

/**
 * Created by Ferin on 2016-08-28.
 */
public class BalanceEnquiry extends Transaction {

    public BalanceEnquiry(){}

    @Override
    public boolean performTransaction(Map<String, Object> data) {
        Account account = (Account) data.get("account");

        System.out.println("Balance Enquiry for: " + account.getClient().getName());

        return account.getAccountNumber() != null;
    }

    @Override
    public Transaction handleRequest(String request) {
        if(request.equalsIgnoreCase("balanceEnquiry")){
            return new BalanceEnquiry();
        }
        else{
            if(nextTransaction != null){
                return nextTransaction.handleRequest(request);
            }
        }
        return null;
    }

}
