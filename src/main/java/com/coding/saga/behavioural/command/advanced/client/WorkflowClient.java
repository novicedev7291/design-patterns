package com.coding.saga.behavioural.command.advanced.client;

import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
public class WorkflowClient extends AbstractClient{
    public WorkflowClient(boolean shouldFailOccasionally) {
        super(shouldFailOccasionally);
    }

    public void addMappingForCompany(String prefix) {
        RequestContext context =
                new RequestContext("workflow-svc", List.of(prefix));
        execute(context);
    }
}
