package com.coding.saga.behavioural.command.advanced;

import com.coding.saga.behavioural.command.advanced.client.WorkflowClient;

import java.util.logging.Logger;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
record WorkflowCommand(String prefix, WorkflowClient client) implements UndoableCommand{
    private static final Logger log = Logger.getLogger(WorkflowCommand.class.getName());
    @Override
    public void execute() {
        client.addMappingForCompany(prefix);
    }

    @Override
    public void undo() {
        log.info("Undoing workflow command due to previous error");

    }
}
