package com.duracell.API.Test_cycle;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

public class RegistrationSteps {

    private static String BASE_URL = "https://api.example.com";
    private static Response response;
    private static String email;

    @Given("I register a new user with email {string}")
    public void iRegisterANewUserWithEmail(String userEmail) {
        email = userEmail;

        JSONObject req = new JSONObject();
        req.put("","");
        // Send POST request for user registration
        response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(req)
                .post("/users/register");

        // Assert registration is successful
        Assert.assertEquals(201, response.getStatusCode());
    }
}

