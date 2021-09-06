package com.coding.saga.behavioural.command.advanced.client;

import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
public class UserClient extends AbstractClient{
    public UserClient(boolean shouldFailOccasionally) {
        super(shouldFailOccasionally);
    }

    public void addAuthUser(String prefix, String email){
        RequestContext context =
                new RequestContext("user-svc", List.of(prefix, email));

        execute(context);
    }
}
