package com.coding.saga.behavioural.command;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class RemoteControlApp {
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        LightBulb bulb = new LightBulb();

        LightOnCommand lightOnCommand = new LightOnCommand(bulb);
        LightOffCommand lightOffCommand = new LightOffCommand(bulb);

        CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(fan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(fan);

        RemoteControl control = new RemoteControl();
        control.setCommand(0, lightOnCommand, lightOffCommand);
        control.setCommand(1, ceilingFanOnCommand, ceilingFanOffCommand);

        control.onPressed(1);
        control.onPressed(0);
        control.offPressed(0);
        control.offPressed(1);
        control.undoPressed();
    }
}
