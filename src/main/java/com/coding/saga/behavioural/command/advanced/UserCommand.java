package com.coding.saga.behavioural.command.advanced;

import com.coding.saga.behavioural.command.advanced.client.UserClient;

import java.util.logging.Logger;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
record UserCommand(String prefix, String email, UserClient client) implements UndoableCommand {
    private static final Logger log = Logger.getLogger(UserCommand.class.getName());
    @Override
    public void execute() {
        client.addAuthUser(prefix, email);
    }

    @Override
    public void undo() {
        log.info("Undoing user-svc operation performed earlier");
    }
}
