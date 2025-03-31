package com.natwest.service;

import com.natwest.client.ApiClient;
import io.restassured.response.Response;

import static utils.ConfigReader.getEndPoint;

public class RestAPINatWestTest {
    public static Response addItem(Object item){
        return ApiClient.postRequest(getEndPoint("path"), item);
    }

    public static Response getItem(String id){
        return ApiClient.getRequest(getEndPoint("path") + "/" + id);
    }

    public static Response getAllItems(){
        return ApiClient.getRequest(getEndPoint("path"));
    }

    public static Response deleteItem(String id){
        return ApiClient.deleteRequest(getEndPoint("path") + "/" + id);
    }

}
