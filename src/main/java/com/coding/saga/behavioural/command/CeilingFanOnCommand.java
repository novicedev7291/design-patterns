package com.coding.saga.behavioural.command;

import lombok.RequiredArgsConstructor;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@RequiredArgsConstructor
class CeilingFanOnCommand implements Command{
    private final CeilingFan fan;

    @Override
    public void execute() {
        fan.switchOn();
    }

    @Override
    public void undo() {
        fan.switchOff();
    }
}
