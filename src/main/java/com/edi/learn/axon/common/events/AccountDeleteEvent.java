package com.edi.learn.axon.common.events;

//import com.edi.learn.axon.common.domain.AccountId;

public class AccountDeleteEvent {
    private String accountId;


    public AccountDeleteEvent(String accountId) {
        this.accountId = accountId;

    }

    public String getAccountId() {
        return accountId;
    }


}