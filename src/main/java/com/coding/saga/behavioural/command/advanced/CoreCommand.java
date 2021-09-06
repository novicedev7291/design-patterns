package com.coding.saga.behavioural.command.advanced;

import com.coding.saga.behavioural.command.advanced.client.CoreClient;

import java.util.logging.Logger;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
record CoreCommand(String prefix,CoreClient client) implements UndoableCommand{
    private static final Logger log = Logger.getLogger(CoreCommand.class.getName());

    @Override
    public void execute() {
        client.createCompany(prefix);
        throw new IllegalStateException("Some problem occurred after company creation request, rollback!!!");
    }

    @Override
    public void undo() {
        log.info("Undoing create company request due to error");
    }
}
