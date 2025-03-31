package com.natwest.stepdefinitions;

import com.natwest.model.Item;
import com.natwest.service.RestAPINatWestTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static utils.ConfigReader.getJsonPath;

public class ProductReturnSteps extends StepsHelper {


    @When("the request to get the item is made")
    public void getRequest() {
        response = RestAPINatWestTest.getItem(String.valueOf(id));
        assertNotNull("Response is null - request may have failed", response);
    }

    @And("an item is returned with the following data")
    public void verifyReturnedItemData(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        assertEquals("Name does not match", data.get("name"), response.jsonPath().getString(getJsonPath("name")));
        assertEquals("CPU Model does not match", data.get("cpuModel"), response.jsonPath().getString(getJsonPath("cpuModel")));
        assertEquals("Price does not match", data.get("price"), String.valueOf(response.jsonPath().getDouble(getJsonPath("price"))));
    }

    @When("the request to get all the items is made")
    public void requestToGetAllTheItems() {
        response = RestAPINatWestTest.getAllItems();
        assertNotNull("Response is null - request may have failed", response);
    }

    @And("list of items are returned")
    public void listOfItemsReturned() {
        List<Item> items = response.jsonPath().getList("", Item.class);
        assert(!items.isEmpty());
        for (Item item : items) {
            assertNotNull("Item ID " + item.getId() + " has a null name", item.getName());
            if (item.getData() != null && item.getData().getPrice() != null && item.getData().getPrice() > 1000) {
                assertNotNull("High-priced item '" + item.getName() + "' is missing CPU model", item.getData().getCpuModel());
            }
        }

    }
}
