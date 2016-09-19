package com.taylor.ferin.frontend.domain.account;

import com.taylor.ferin.frontend.domain.client.Client;

import java.io.Serializable;

/**
 * Created by Ferin on 2016-08-28.
 */
public class Account implements Serializable{
    private Long id;

    private Client client;
    private String accountNumber;
    private String accountType;
    private String balance;
    private String limit;
    private String pin;


    private Account(){}

    private Account(Builder builder)
    {
        this.accountNumber = builder.accountNumber;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.client = builder.client;
        this.limit = builder.limit;
        this.pin = builder.pin;
        this.id = builder.id;
    }

    public Client getClient() {
        return client;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public String getLimit() {
        return limit;
    }

    public String getPin() {
        return pin;
    }

    public Long getId() {
        return id;
    }


    public static class Builder
    {
        private Client client;
        private String accountNumber;
        private String accountType;
        private String balance;
        private String limit;
        private String pin;
        private Long id;

        public Builder client(Client client){
            this.client = client;
            return this;
        }

        public Builder accountType(String accountType)
        {
            this.accountType = accountType;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return  this;
        }

        public Builder balance(String balance)
        {
            this.balance = balance;
            return this;
        }

        public Builder limit(String limit)
        {
            this.limit = limit;
            return  this;
        }

        public Builder pin(String pin)
        {
            this.pin = pin;
            return this;
        }

        public Builder accountNumber(String accountNumber)
        {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder copy(Account account)
        {
            this.id = account.id;
            this.accountNumber = account.accountNumber;
            this.accountType = account.accountType;
            this.balance = account.balance;
            this.limit = account.limit;
            this.pin = account.pin;
            this.client = account.client;

            return this;
        }

        public Account build()
        {
            return  new Account(this);
        }
    }


}
