package com.natwest.stepdefinitions;

import com.natwest.service.RestAPINatWestTest;
import io.cucumber.java.After;
import lombok.extern.slf4j.Slf4j;

import static com.natwest.stepdefinitions.StepsHelper.response;

@Slf4j
public class Hooks {

    @After("@addItem")
    public void cleanUpAfterScenario() {
        if (response != null && response.getStatusCode() == 200) {
            String id = response.jsonPath().getString("id");
            if (id != null) {
                RestAPINatWestTest.deleteItem(id);
                System.out.println("Cleaned up item with id = " + id);
            }
        }
    }

}
