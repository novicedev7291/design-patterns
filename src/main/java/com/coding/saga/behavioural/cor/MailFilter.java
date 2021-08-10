package com.coding.saga.behavioural.cor;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
@FunctionalInterface
public interface MailFilter {
    default MailFilter appendNext(MailFilter next) {
        return mail -> {
            filter(mail);
            next.filter(mail);
        };
    }

    void filter(Mail mail);
}
