package com.edi.learn.axon.command.commands;
public class CreateAccountCommand {

    private String accountId;
    private String accountName;
    private long amount;

    public CreateAccountCommand(String accountId, String accountName, long amount) {
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
