package org.example.UserData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class UserDataTest {

    private static final String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest() {
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

    }

}