package com.taylor.ferin.frontend.factories.transaction;

import com.taylor.ferin.frontend.domain.transaction.Transaction;
import com.taylor.ferin.frontend.domain.transaction.impl.BalanceEnquiry;
import com.taylor.ferin.frontend.domain.transaction.impl.Deposit;
import com.taylor.ferin.frontend.domain.transaction.impl.Withdraw;

/**
 * Created by Ferin on 2016-08-28.
 */
public class TransactionFactory {
    public static Transaction getTransaction(String value){
        Transaction chain = setUpchain();
        return chain.handleRequest(value);
    }

    public static Transaction setUpchain(){
        Transaction balanceEnquiry = new BalanceEnquiry();
        Transaction deposit = new Deposit();
        Transaction withdraw = new Withdraw();

        balanceEnquiry.setNextTransaction(deposit);
        deposit.setNextTransaction(withdraw);

        return balanceEnquiry;
    }
}
