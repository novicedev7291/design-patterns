package com.coding.saga.behavioural.cor;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
class BusinessFilter implements MailFilter{

    @Override
    public void filter(Mail mail) {
        if(isBusiness(mail)) {
            System.out.println("Forwarding to business mail business@xyz.com");
        }
    }

    private boolean isBusiness(Mail mail) {
        return mail.to().equalsIgnoreCase("business@xyz.com");
    }
}
