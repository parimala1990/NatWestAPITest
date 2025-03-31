package com.natwest.stepdefinitions;

import com.natwest.service.RestAPINatWestTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import static utils.ConfigReader.getJsonPath;

public class ItemCreatorSteps extends StepsHelper {


    @When("the request to add the item is made")
    public void postRequest() {
        response = RestAPINatWestTest.addItem(item);
        assertNotNull("Response from POST request is null", response);
    }

    @Then("verify an item {string} is created")
    public void verifyItemReturned(String expectedName) {
        String name = getJsonPath("name");
        if(expectedName.isEmpty()){
            assertNull(response.jsonPath().get(name));
        }
        else {String returnedName = response.jsonPath().get(name);
        assertEquals("Unexpected status code", expectedName, returnedName); }
    }

    @Given("an item is created with the following data")
    public void anItemIsCreatedWithTheFollowingData(DataTable dataTable) {
        setItem(dataTable);
    }

    @And("verify CPU model is {string}")
    public void verifyCPUModel(String expectedCPUModel) {
        String cpuModel = getJsonPath("cpuModel");
        if(expectedCPUModel.isEmpty()){
            assertNull(response.jsonPath().get(cpuModel));
        }
        else {String returnedCPUModel = response.jsonPath().get(cpuModel);
            assertEquals("Unexpected status code", expectedCPUModel, returnedCPUModel); }

    }

    @And("verify price model is {string}")
    public void verifyPrice(String expectedPrice) {
        String price = getJsonPath("price");
        if (expectedPrice == null || expectedPrice.isEmpty()) {
            assertNull("Expected price to be null or missing", response.jsonPath().get(price));
        } else {
            double actualPrice = response.jsonPath().getDouble(price);
            double expected = Double.parseDouble(expectedPrice);
            assertEquals("Price does not match", expected, actualPrice, 0.01);
        }
    }
}
