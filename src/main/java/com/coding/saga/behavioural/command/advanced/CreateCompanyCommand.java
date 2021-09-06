package com.coding.saga.behavioural.command.advanced;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class CreateCompanyCommand implements Command {
    private static final Logger log = Logger.getLogger(CreateCompanyCommand.class.getName());

    private final Deque<UndoableCommand> stack;
    private final List<UndoableCommand> commands;

    public CreateCompanyCommand() {
        this.stack = new ArrayDeque<>();
        this.commands = new ArrayList<>();
    }

    public void addCommand(UndoableCommand command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        try{
            for (UndoableCommand command : commands) {
                command.execute();
                stack.push(command);
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "Could not create company, undoing all operations till now");
            undoAll();
        }finally {
            stack.clear();
        }
    }

    private void undoAll() {
        try{
            while (!stack.isEmpty()) {
                stack.pop().undo();
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "Could not undo cleanly, please check logs");
        }
    }
}
