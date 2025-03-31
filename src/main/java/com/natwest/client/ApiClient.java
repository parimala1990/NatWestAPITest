package com.natwest.client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static utils.ConfigReader.getEndPoint;

public class ApiClient {

    public static RequestSpecification reqSpecConfig(){

        return RestAssured.given()
                .baseUri(getEndPoint("baseURL"))
                .contentType(ContentType.JSON);
    }

    public static Response postRequest(String path, Object body)
    {
        return reqSpecConfig().log().all().body(body).post(path).then().log().all().extract().response();
    }

    public static Response getRequest(String path)
    {
        return reqSpecConfig().log().all().get(path).then().log().all().extract().response();
    }

    public static Response deleteRequest(String path)
    {
        return reqSpecConfig().log().all().delete(path).then().log().all().extract().response();
    }

}
