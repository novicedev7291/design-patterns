package com.coding.saga.behavioural.command.advanced;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class OnBoardingClient {

    public Response onBoard(CompanyData data) {
        Command command = CommandFactory.newCommand(data);

        Command timeWrappedCommand = timeWrapper(command);
        timeWrappedCommand.execute();

        return new Response(200, "Successfully created company");
    }

    private static Command timeWrapper(Command command) {
        return () -> {
            long beforeMilliSeconds = System.currentTimeMillis();
            command.execute();
            long afterMilliSeconds = System.currentTimeMillis();
            System.out.printf("Total time took to execute %ds", (afterMilliSeconds - beforeMilliSeconds) / 1000);
        };
    }
}
