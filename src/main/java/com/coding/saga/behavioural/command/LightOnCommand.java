package com.coding.saga.behavioural.command;

import lombok.RequiredArgsConstructor;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@RequiredArgsConstructor
class LightOnCommand implements Command{
    private final LightBulb lightBulb;

    @Override
    public void execute() {
        lightBulb.on();
    }

    @Override
    public void undo() {
        lightBulb.off();
    }
}
