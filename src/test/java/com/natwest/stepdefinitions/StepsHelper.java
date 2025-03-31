package com.natwest.stepdefinitions;

import com.natwest.model.Data;
import com.natwest.model.Item;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;

import java.util.Map;

public class StepsHelper {

    protected static Response response;
    protected static Item item;

    protected static int id;
    protected void setItem(DataTable dataTable)
    {
        Map<String, String> data = dataTable.asMaps().get(0);
        item = new Item();
        item.setName(data.get("name"));

        Data itemData = new Data();

        if (data.containsKey("cpuModel") && !data.get("cpuModel").isEmpty() ) {
            itemData.setCpuModel(data.get("cpuModel"));
        }

        if (data.containsKey("price") && !data.get("price").isEmpty()) {
            itemData.setPrice(Double.parseDouble(data.get("price")));
        }

        if (data.containsKey("year") && !data.get("year").isEmpty()) {
            itemData.setYear(Integer.parseInt(data.get("year")));
        }

        if (data.containsKey("hardDiskSize") && !data.get("hardDiskSize").isEmpty()) {
            itemData.setHardDiskSize(data.get("hardDiskSize"));
        }

        item.setData(itemData);
    }

}
