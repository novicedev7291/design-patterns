package com.coding.saga.behavioural.command.advanced;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
public interface UndoableCommand extends Command{
    void undo();
}
