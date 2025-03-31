package com.natwest.stepdefinitions;

import com.natwest.service.RestAPINatWestTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class CommonSteps extends  StepsHelper{


    @Given("an id for item is {int}")
    public void getIdForItem(int inputId) {
        id=inputId;
    }

    @Then("a {int} response code is returned")
    public void verifyStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Given("an item is created with no payload")
    public void createItemWithNoPayload() {
        response = RestAPINatWestTest.addItem("");
    }
}
