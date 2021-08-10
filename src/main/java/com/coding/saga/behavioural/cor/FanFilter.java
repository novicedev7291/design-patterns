package com.coding.saga.behavioural.cor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class FanFilter implements MailFilter{
    private final List<String> keywords =
            Arrays.asList("Wonderful", "Great", "Amazing", "Beautiful");

    @Override
    public void filter(Mail mail) {
        if(isFanMail(mail)) {
            System.out.println("Fan mail, forwarded to CEO directly");
        }
    }

    private boolean isFanMail(Mail mail) {
        Predicate<String> foundKeyword =
                key -> mail.subject().contains(key.toUpperCase())
                        || mail.subject().contains(key.toLowerCase())
                        || mail.subject().contains(key);

        return keywords.stream().anyMatch(foundKeyword);
    }
}
