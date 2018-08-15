package com.edi.learn.axon.command.commands;

//import com.edi.learn.axon.common.domain.AccountId;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class DeleteAccountCommand {
    @TargetAggregateIdentifier
    private String accountId;

    public DeleteAccountCommand(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

}
