package com.coding.saga.behavioural.command;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;
    public static final int SLOTS = 4;

    public RemoteControl() {
        onCommands = new Command[SLOTS];
        offCommands = new Command[SLOTS];

        for(int i = 0 ; i < SLOTS; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
        undoCommand = new NoCommand();
    }

    public void setCommand(int index, Command on, Command off) {
        onCommands[index] = on;
        offCommands[index] = off;
    }

    public void onPressed(int index) {
        onCommands[index].execute();
        undoCommand = onCommands[index];
    }

    public void offPressed(int index) {
        offCommands[index].execute();
        undoCommand = offCommands[index];
    }

    public void undoPressed() {
       undoCommand.undo();
    }
}
