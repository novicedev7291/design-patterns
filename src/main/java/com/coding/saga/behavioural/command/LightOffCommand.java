package com.coding.saga.behavioural.command;

import lombok.RequiredArgsConstructor;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@RequiredArgsConstructor
class LightOffCommand implements Command{
    private final LightBulb lightBulb;


    @Override
    public void execute() {
        lightBulb.off();
    }

    @Override
    public void undo() {
        lightBulb.on();
    }
}
