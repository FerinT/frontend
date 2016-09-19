package com.taylor.ferin.frontend.factories.account;

import com.taylor.ferin.frontend.domain.account.Account;

import java.util.Map;

/**
 * Created by Ferin on 2016-08-28.
 */
public interface AccountFactory {
    Account createAccount(Map<String, Object> accountDetails);
}
