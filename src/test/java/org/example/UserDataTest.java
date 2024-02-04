package org.example;
import io.restassured.http.ContentType;
import org.junit.Assert;
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
                .get(URL + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        //проверяем id в ссылке аватара
        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        //проверяем email пользователей на соответствие домена
        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));
    }
}