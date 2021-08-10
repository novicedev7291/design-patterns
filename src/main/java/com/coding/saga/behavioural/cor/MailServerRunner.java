package com.coding.saga.behavioural.cor;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="kuldeepyadav7291@gmail.com">Kuldeep</a>
 */
public class MailServerRunner {
    public static void main(String[] args) {
        List<Mail> mails = createMails();

        MailServer server = new MailServer();
        server.process(mails);
    }

    private static List<Mail> createMails() {
        Mail spam = new Mail("Three Night Vacations For Free",
                "You can win exotic vacations in france on affordable prices",
                "tourguide@blabla.com",
                "ceo@abc.com");

        Mail fan = new Mail("Amazing Product Loved It!",
                "Hi, I am delighted to tell you that I loved the machine....",
                "kuldeep.yadav@xyz.com",
                "ceo@abc.com"
        );

        Mail business = new Mail(
                "Dealership Requirements Document",
                "Hi, I am dealer and would like to partner with your company...",
                "zyz@abc.com",
                "business@xyz.com"
        );

        Mail other = new Mail(
                "Machine Stopped Working",
                "Hi, I bought this machine from store and it ....",
                "vincent@rocketmail.com",
                "consumer@xyz.com"
        );
        return Arrays.asList(other, fan, spam, business);
    }
}
