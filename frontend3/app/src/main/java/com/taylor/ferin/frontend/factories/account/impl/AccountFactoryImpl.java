package com.taylor.ferin.frontend.factories.account.impl;

import com.taylor.ferin.frontend.domain.account.Account;
import com.taylor.ferin.frontend.domain.client.Client;
import com.taylor.ferin.frontend.factories.account.AccountFactory;

import java.util.Map;

/**
 * Created by Ferin on 2016-08-28.
 */
public class AccountFactoryImpl implements AccountFactory {

    @Override
    public Account createAccount(Map<String, Object> accountDetails) {
        return new Account.Builder()
                .accountNumber(accountDetails.get("accountNumber").toString())
                .accountType(accountDetails.get("accountType").toString())
                .balance(accountDetails.get("balance").toString())
                .limit(accountDetails.get("limit").toString())
                .pin(accountDetails.get("pin").toString())
                .client((Client) accountDetails.get("client"))
                .id(Long.parseLong(accountDetails.get("id").toString()))
                .build();
    }
}
