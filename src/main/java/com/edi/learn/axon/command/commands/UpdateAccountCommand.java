package com.edi.learn.axon.command.commands;

//import com.edi.learn.axon.common.domain.AccountId;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class UpdateAccountCommand {
    @TargetAggregateIdentifier
    private String accountId;
    private String accountName;
    private long amount;

    public UpdateAccountCommand(String accountId, String accountName, long amount) {
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
