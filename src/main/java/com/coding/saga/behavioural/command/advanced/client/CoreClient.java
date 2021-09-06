package com.coding.saga.behavioural.command.advanced.client;

import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
public class CoreClient extends AbstractClient{
    public CoreClient(boolean shouldFailOccasionally) {
        super(shouldFailOccasionally);
    }

    public void createCompany(String companyPrefix) {
        RequestContext context =
                new RequestContext("core-svc", List.of(companyPrefix, companyPrefix));
        execute(context);
    }
}
