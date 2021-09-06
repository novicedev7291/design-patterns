package com.coding.saga.behavioural.command.advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OnBoardingClientTest {
    private final OnBoardingClient client = new OnBoardingClient();

    @Test
    void shouldFailToCreateCompany() {
        CompanyData data = new CompanyData(
                "DUMMY",
                "Dummy Company",
                "dummy.1234@dummy.net",
                "Address 2",
                "India"
        );

        Response response = client.onBoard(data);

        assertNotNull(response);
        assertEquals(400,response.status());
    }

    @Test
    void shouldCreateCompany() {
    }

}