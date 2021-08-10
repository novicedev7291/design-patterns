package com.coding.saga.behavioural.cor;

import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class MailServer {
    private final MailFilter filter;

    public MailServer() {
        filter = init();
    }

    private MailFilter init() {
        return new SpamFilter()
                .appendNext(new FanFilter())
                .appendNext(new BusinessFilter());
    }

    public void process(List<Mail> mails) {
        mails.forEach(filter::filter);
    }
}
