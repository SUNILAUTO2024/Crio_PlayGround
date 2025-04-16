package com.project.Crio_Playground.stepdefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;

public class Get_Endpoints extends BaseSteps {
    private static String endpoint;
    private static Response resp;
    private static  String token;

    @When("user send the post request with uid and pswd")
    public void sendPostRequestWithCredentials() {

        endpoint=prop.getProperty("Base_URL_PD")+prop.getProperty("authenticate");
        resp = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{ \"username\": \"" + td.get(ScenarioName).get("Userid") + "\", \"password\": \"" + td.get(ScenarioName).get("Password") + "\" }")
                .post(endpoint);

//        resp.prettyPrint();
        logger.pass("Send Authentication post request");

    }
    @Then("user validate response body for Duracell user details")
    public void user_validates_response_body_for_duracell_user_details() {
        Map<String, Object> expectedValues = new HashMap<>();
        expectedValues.put("userName", "cestestduracell");
        expectedValues.put("email", "cestestpuredrive@example.com");
        expectedValues.put("firstName", "cestestpuredrive");
        expectedValues.put("supplier", "duracell energy");
        expectedValues.put("roles", "[3]");
        expectedValues.put("status", null);
        expectedValues.put("status2", "ok");

        // Fetch the required data from the response body
        Map<String, Object> actualValues = new HashMap<>();
        actualValues.put("userName", resp.getBody().jsonPath().getString("data.userInfo.userName"));
        actualValues.put("email", resp.getBody().jsonPath().getString("data.userInfo.email"));
        actualValues.put("firstName", resp.getBody().jsonPath().getString("data.userInfo.firstName"));
        actualValues.put("supplier", resp.getBody().jsonPath().getString("data.userInfo.supplier"));
        actualValues.put("roles", resp.getBody().jsonPath().getString("data.userInfo.roles"));
        actualValues.put("status", resp.getBody().jsonPath().getString("data.userInfo.status"));
        actualValues.put("status2", resp.getBody().jsonPath().getString("status"));

        // Validate and log the results
        expectedValues.forEach((key, expectedValue) -> {
            Object actualValue = actualValues.get(key);
            Assert.assertEquals("Asserting " + key + " - ", expectedValue, actualValue);
            logger.pass("Verified " + key + " in response body - " + actualValue +" is actual vs - "+ expectedValue+" - is as expected.");
        });
    }
    @When("Set token Global and endpoint for installer list")
    public void set_token_global_and_endpoint_for_installer_list() {
        endpoint=prop.getProperty("Base_URL_PD")+prop.getProperty("installer_list");
        // Extract the token from the response
         token = resp.jsonPath().getString("data.userInfo.token");
        logger.info("Set token "+token+" for next request");
    }
    @When("Set token Global and endpoint for Language list")
    public void set_token_global_and_endpoint_for_Language_list() {
        endpoint=prop.getProperty("Base_URL_PD")+prop.getProperty("language_list");
        // Extract the token from the response
        token = resp.jsonPath().getString("data.userInfo.token");
        logger.info("Set token "+token+" for next request");
    }
    @When("send Get request with valid token")
            public void send_get_request_with_valid_token() {

        endpoint=prop.getProperty("Base_URL_PD")+prop.getProperty("TZ");

        resp = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get(endpoint);
        resp.prettyPrint();
        logger.pass("Send Get details request with token of login user");
    }

    @When("status code must equal to {int} ok post login")
    public void status_code_must_equal_to_ok(long int1) {
        status_code_200();
    }
    public void status_code_200(){
        int int1=200;
        int Actual_Status=resp.statusCode();
        Assert.assertEquals(int1,Actual_Status);
        logger.pass("Expected status code="+int1+" matches with actual Status code ="+Actual_Status);
    }
    @Then("validate status code")
    public void validate_status_code() {
        status_code_200();
    }
    @Then("validate response")
    public void validate_response() {
        i_validate_the_json_response();
    }
    @Then("I validate the JSON response")
    public void i_validate_the_json_response() {
        resp.then()
                .statusCode(200) // Validate HTTP status code
                .body("size()", greaterThan(0)) // Validate non-empty array
                .body("findAll { it.userName == 'cestestinstaller' }.email[0]", equalTo("cestestinstaller@example.com")) // Validate specific user
                .body("find { it.id == 1194 }.company", equalTo("cawood")); // Validate company for a specific ID

        // Additional validation for specific conditions

        resp.then().body("id", everyItem(greaterThan(0))); // Validate all IDs are positive
        logger.pass("Validated Response of Get_Installer list");
    }

    @Then("validate response for invalid user role")
    public void validate_response_for_invalid_user_role() {
        String status = resp.getBody().jsonPath().getString("status");
        String InValid_user = resp.getBody().jsonPath().getString("data.msg");
        resp.then()
                .statusCode(200) // Validate HTTP status code
                .body("data.code", equalTo("BAD_USER_ROLE")) // Validate BAD_USER_ROLE
                .body("data.msg", equalTo("Invalid User Role")) // Validate Invalid User Role
                .body("status", equalTo("fail"));
        // Additional validation for specific conditions
        logger.pass("Validated Response of Get_Installer list & get this error = "+InValid_user);
        logger.pass("Validated Response of Get_Installer list & get this status = "+status);
    }
    @Then("validate response for Language list")
    public void and_validate_response_for_language_list() {
        //resp.prettyPrint();
        String[] language = {resp.jsonPath().getString("name[0]"),resp.jsonPath().getString("name[1]"),resp.jsonPath().getString("name[2]")};

                resp.then()
                    .statusCode(200) // Validate HTTP status code
                    .body("id[0]", equalTo(1)).body("id[1]", equalTo(2)).body("id[2]", equalTo(3))
                    .body("name[0]", equalTo("English")).body("name[1]", equalTo("Spanish")).body("name[2]", equalTo("Dutch"));

                for (String s:language) {
                    logger.pass("Verified " + s + " Language in response body -  actual vs expected is matched");

                }
    }
    @When("Set token Global and endpoint for TZ list")
    public void set_token_global_and_endpoint_for_tz_list() {
        endpoint=prop.getProperty("Base_URL_PD")+prop.getProperty("TZ");
        // Extract the token from the response
        token = resp.jsonPath().getString("data.userInfo.token");
        logger.info("Set token "+token+" for next request");

    }

    @Then("validate response for Time Zone list")
    public void and_validate_response_for_TZ_list() {
        String[] TZz = {resp.jsonPath().getString("name[0]"),resp.jsonPath().getString("name[1]"),resp.jsonPath().getString("name[2]")};
        resp.prettyPrint();
        resp.then()
                .statusCode(200) // Validate HTTP status code
                .body("id[0]", equalTo(47)).body("id[1]", equalTo(54)).body("id[2]", equalTo(63))
                .body("name[0]", equalTo("GMT Standard Time (UTC+00:00)")).body("name[1]", equalTo("Central European Standard Time (UTC+01:00)")).body("name[2]", equalTo("South Africa Standard Time (UTC+02:00)"))
                 .body("active[0]", equalTo(true)).body("active[1]", equalTo(true)).body("active[1]", equalTo(true));

        for (String s:TZz) {
            logger.pass("Verified " + s + " TZ in response body -  actual vs expected is matched");

        }


    }

}
