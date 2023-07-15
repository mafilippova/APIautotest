package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;


public class ApiTest {

    @Test
    public void apiTest(){
        Response response = RestAssured
                .get("http://keys4steam.ru/")
                .andReturn();
        response.prettyPrint();
    }

    @Test
    public void apiPost(String id, String quantity){
        Specifications.InstallSpecifications
    }
}
