package com.natwest.stepdefinitions;

import com.natwest.service.RestAPINatWestTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeleteProductSteps extends StepsHelper{

    String createdItemId;

    @When("the request to delete an item with the id is made")
    public void deleteRequest() {
        createdItemId= response.jsonPath().getString("id");

        response = RestAPINatWestTest.deleteItem(response.jsonPath().getString("id"));
        assertNotNull("Response is null - request may have failed", response);
    }

    @And("verify delete message is returned")
    public void verifyDeleteMessageIsReturned() {
        assertEquals("Unexpected deletion message", "Object with id = " + createdItemId + " has been deleted.", response.jsonPath().getString("message"));
    }
}
