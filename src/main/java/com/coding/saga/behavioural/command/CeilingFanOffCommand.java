package com.coding.saga.behavioural.command;

import lombok.RequiredArgsConstructor;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@RequiredArgsConstructor
class CeilingFanOffCommand implements Command{
    private final CeilingFan fan;
    @Override
    public void execute() {
       fan.switchOff();
    }

    @Override
    public void undo() {
        fan.switchOn();
    }
}
