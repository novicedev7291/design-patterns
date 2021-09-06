package com.coding.saga.behavioural.command.advanced.client;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
record MockRequestCallable(RequestContext context) implements Callable<String> {
    private static final Logger log = Logger.getLogger(MockRequestCallable.class.getName());

    @Override
    public String call() throws Exception {
        log.info(String.format(
                "Executing request %s with params %s",
                context.requestName(),
                String.join(",", context.params())
        ));
        Thread.sleep(TimeUnit.SECONDS.toSeconds(5));
        log.info("Request finished");
        return "Success";
    }
}
