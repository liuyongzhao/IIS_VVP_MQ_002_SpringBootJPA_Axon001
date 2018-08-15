
package com.edi.learn.axon.query.handlers;

import com.edi.learn.axon.common.events.AccountCreatedEvent;
import com.edi.learn.axon.common.events.AccountDeleteEvent;
import com.edi.learn.axon.common.events.AccountUpdateEvent;
import com.edi.learn.axon.query.entries.BankAccountEntry;
import com.edi.learn.axon.query.repository.BankAccountEntryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class BankAccountEventHandler {
    private static final Logger LOGGER = getLogger(BankAccountEventHandler.class);
    @Autowired
    BankAccountEntryRepository repository;

    @EventHandler
    public void on(AccountCreatedEvent event){
        LOGGER.debug("repository data is updated");
        repository.save(new BankAccountEntry(event.getAccountId(), event.getAccountName(), event.getAmount()));
    }
    @EventHandler
    public void on(AccountUpdateEvent event){
        LOGGER.debug("repository data is updated");
        repository.save(new BankAccountEntry(event.getAccountId(), event.getAccountName(), event.getAmount()));
    }
    @EventHandler
    public void on(AccountDeleteEvent event){
        LOGGER.debug("repository data is updated");
        repository.delete(event.getAccountId());
    }
}

