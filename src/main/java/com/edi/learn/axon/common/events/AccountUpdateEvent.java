package com.edi.learn.axon.common.events;

//import com.edi.learn.axon.common.domain.AccountId;

public class AccountUpdateEvent {
    private String accountId;
    private String accountName;
    private long amount;

    public AccountUpdateEvent(String accountId, String accountName, long amount) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public long getAmount() {
        return amount;
    }
}


