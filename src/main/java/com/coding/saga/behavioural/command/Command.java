package com.coding.saga.behavioural.command;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
public interface Command {
    void execute();
    void undo();
}
