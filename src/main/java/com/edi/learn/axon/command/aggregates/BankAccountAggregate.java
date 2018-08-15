package com.edi.learn.axon.command.aggregates;

import com.edi.learn.axon.command.commands.CreateAccountCommand;
//import com.edi.learn.axon.command.commands.WithdrawMoneyCommand;
import com.edi.learn.axon.command.commands.DeleteAccountCommand;
import com.edi.learn.axon.command.commands.UpdateAccountCommand;
//import com.edi.learn.axon.common.domain.AccountId;
import com.edi.learn.axon.common.events.AccountCreatedEvent;
//import com.edi.learn.axon.common.events.MoneyWithdrawnEvent;
import com.edi.learn.axon.common.events.AccountDeleteEvent;
import com.edi.learn.axon.common.events.AccountUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;
import static org.slf4j.LoggerFactory.getLogger;

@Aggregate
public class BankAccountAggregate {

    private static final Logger LOGGER = getLogger(BankAccountAggregate.class);

    @AggregateIdentifier
    private String accountId;
    private String accountName;
    private BigDecimal balance;

    public BankAccountAggregate() {
    }

    @CommandHandler
    public BankAccountAggregate(CreateAccountCommand command){
        LOGGER.debug("Construct a new BankAccount");
        apply(new AccountCreatedEvent(command.getAccountId(), command.getAccountName(), command.getAmount()));
    }

    @CommandHandler
    //更新
    public void handle(UpdateAccountCommand command){
        apply(new AccountUpdateEvent(command.getAccountId(), command.getAccountName(), command.getAmount()));
    }
    @CommandHandler
    //删除
    public void handle(DeleteAccountCommand command){
        apply(new AccountDeleteEvent(command.getAccountId()));
    }

    @EventHandler
    public void on(AccountCreatedEvent event){
        this.accountId = event.getAccountId();
        this.accountName = event.getAccountName();
        this.balance = new BigDecimal(event.getAmount());
        LOGGER.info("Account {} is created with balance {}", accountId, this.balance);
    }
    @EventHandler
    public void on(AccountUpdateEvent event){
        this.accountId = event.getAccountId();
        this.accountName = event.getAccountName();
        this.balance = new BigDecimal(event.getAmount());
        LOGGER.info("Account {} is updated with balance {}", accountId, this.balance);
    }
    @EventHandler
    public void on(AccountDeleteEvent event){
        this.accountId = event.getAccountId();
        LOGGER.info("Account {} is deleted with balance {}", accountId, this.balance);
    }

    /*@EventHandler
    public void on(MoneyWithdrawnEvent event){
        BigDecimal result = this.balance.subtract(new BigDecimal(event.getAmount()));
        if(result.compareTo(BigDecimal.ZERO)<0)
            LOGGER.error("Cannot withdraw more money than the balance!");
        else {
            this.balance = result;
            LOGGER.info("Withdraw {} from account {}, balance result: {}", event.getAmount(), accountId, balance);
        }
    }*/

    @Id
    public String getAccountId() {
        return accountId.toString();
    }

    public void setAccountId(String accountId) {
        this.accountId = new String(accountId);
    }

    @Column
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
