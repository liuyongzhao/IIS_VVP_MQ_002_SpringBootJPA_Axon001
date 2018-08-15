package com.edi.learn.axon.query.entries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccountEntry {
    @Id
    private String accountId;
    @Column
    private String accountName;
    @Column
    private long amount;

    public BankAccountEntry(){

    }
    public BankAccountEntry(String id, String name, long amount){
        this.accountId = id;
        this.accountName = name;
        this.amount = amount;
    }
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
