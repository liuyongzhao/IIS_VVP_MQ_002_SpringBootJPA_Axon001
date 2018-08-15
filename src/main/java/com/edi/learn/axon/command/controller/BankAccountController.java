package com.edi.learn.axon.command.controller;

import com.edi.learn.axon.command.commands.CreateAccountCommand;
//import com.edi.learn.axon.command.commands.WithdrawMoneyCommand;
import com.edi.learn.axon.command.commands.DeleteAccountCommand;
import com.edi.learn.axon.command.commands.UpdateAccountCommand;
//import com.edi.learn.axon.common.domain.AccountId;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/bank")
public class BankAccountController {

    private static final Logger LOGGER = getLogger(BankAccountController.class);

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(name = "/create",method = RequestMethod.POST)
    public void create() {
        LOGGER.info("create");
        String id1 ="1";
        String id2 ="2";
        LOGGER.debug("Account id: {}  {}", id1,id2);
        commandGateway.send(new CreateAccountCommand(id1, "MyAccount1",1000));
        commandGateway.send(new CreateAccountCommand(id2, "MyAccount2",2000));
    }

    @RequestMapping(name = "/update",method = RequestMethod.PUT)
    public void update() {
        LOGGER.info("update");
        String id = "1";
        LOGGER.debug("Account id: {}", id);
        commandGateway.send(new UpdateAccountCommand(id, "MyAccount",200));

    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(HttpServletResponse response,@PathVariable("id")String id) throws IOException {
        LOGGER.info("delete");
        //String id = "54a3b0df-0921-4555-a6f9-3a5126706ec1";
        LOGGER.debug("Account id: {}", id);
        commandGateway.send(new DeleteAccountCommand(id));

    }


}
