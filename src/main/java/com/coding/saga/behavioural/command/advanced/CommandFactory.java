package com.coding.saga.behavioural.command.advanced;

import com.coding.saga.behavioural.command.advanced.client.CoreClient;
import com.coding.saga.behavioural.command.advanced.client.UserClient;
import com.coding.saga.behavioural.command.advanced.client.WorkflowClient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class CommandFactory {

    public static Command newCommand(CompanyData data) {
        UserCommand userCommand = new UserCommand(data.prefix(),
                data.email(), new UserClient(false));
        WorkflowCommand workflowCommand =
                new WorkflowCommand(data.prefix(), new WorkflowClient(false));
        CoreCommand coreCommand =
                new CoreCommand(data.prefix(), new CoreClient(false));

        CreateCompanyCommand compositeCommand = new CreateCompanyCommand();
        compositeCommand.addCommand(userCommand);
        compositeCommand.addCommand(workflowCommand);
        compositeCommand.addCommand(coreCommand);

        return compositeCommand;
    }
}
