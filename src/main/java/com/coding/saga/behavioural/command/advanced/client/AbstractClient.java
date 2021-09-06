package com.coding.saga.behavioural.command.advanced.client;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class AbstractClient {
    private static final Logger log = Logger.getLogger(AbstractClient.class.getName());
    private final Random rand = new Random(55551);
    private final boolean shouldFailOccasionally;

    protected AbstractClient(boolean shouldFailOccasionally) {
        this.shouldFailOccasionally = shouldFailOccasionally;
    }

    protected int nextNumber() {
        return rand.nextInt(104928);
    }

    protected void execute(RequestContext context) {
        int randomNumber = 2;
        if(shouldFailOccasionally) {
            randomNumber = nextNumber();
        }

        if(randomNumber % 2 != 0) throw new IllegalStateException("Failed to add auth user");

        try{
            log.info(String.format(
                    "Executing request %s with params %s",
                    context.requestName(),
                    String.join(",", context.params())
            ));
            TimeUnit.SECONDS.sleep(2);
            log.info("Request finished");
        }catch (InterruptedException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
