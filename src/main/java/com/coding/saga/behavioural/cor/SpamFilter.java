package com.coding.saga.behavioural.cor;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class SpamFilter implements MailFilter{
    private final List<String> allowedMails = Arrays.asList(
            "abc@xyz.com",
            "zyz@abc.com",
            "kuldeep.yadav@xyz.com",
            "johnoliver@xyz.com",
            "vincent@rocketmail.com"
    );

    @Override
    public void filter(Mail mail) {
        if(isSpam(mail)) {
            System.out.println("Ignoring spam mail");
        }
    }

    private boolean isSpam(Mail mail) {
        return !allowedMails.contains(mail.from());
    }
}
