//package com.vtiger.stepdefinitions;
//
//import com.github.javafaker.Faker;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.junit.Assert;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.hamcrest.Matchers.equalTo;
//
//public class endpoint_steps extends BaseSteps {
//
//    private String jsonData;
//    private String requestBody;
//    private static String id;
//    private static String endpoint;
//    private static Response response;
//    private static Faker faker;
//
//    @Given("endpoint {string}")
//    public void endpoint(String url) {
//        endpoint = url.contains("{id}") ? url.replace("{id}", id) : url;
//        logger.pass(url + " ->> Fetch this endpoint successfully");
//    }
//
//    @And("user send the get request")
//    public void userSendTheGetRequest() {
//        response = RestAssured.get(endpoint);
//        logger.pass("->> Sent GET request to this endpoint");
//    }
//
////    @Then("status code should equal to {int}")
////    public void validateStatusCode(Integer expectedStatusCode) {
////        response.then().statusCode(expectedStatusCode);
////        if (expectedStatusCode.equals(response.getStatusCode())) {
////            logger.pass("Status code validated successfully");
////        } else {
////            logger.fail("Status code does not match");
////        }
////        logger.info("Status is = " + response.getStatusCode());
////    }
//
////    @Then("user validate response for {string}")
////    public void validateResponse(String validationType) {
////        Map<String, String> validationMap = switch (validationType) {
////            case "invalid userName" -> Map.of(
////                    "data.code", "BAD_USERNAME",
////                    "data.msg", "Invalid Username"
////            );
////            case "invalid password" -> Map.of(
////                    "data.code", "BAD_PASSWORD",
////                    "data.msg", "Invalid Password",
////                    "status", "fail"
////            );
////            case "locked account" -> Map.of(
////                    "data.code", "LOCK_USER",
////                    "data.msg", "User Locked",
////                    "status", "fail"
////            );
////            default -> throw new IllegalArgumentException("Invalid validation type: " + validationType);
////        };
////
////        validationMap.forEach((key, expectedValue) -> {
////            String actualValue = response.jsonPath().getString(key);
////            Assert.assertEquals(String.format("%s value does not match", key), expectedValue, actualValue);
////            logger.pass(String.format("%s value matches with expected value", key));
////        });
////    }
//
//
//
//    @Then("user validate response body")
//    public void validateValidLoginResponse() {
//        // Validate status field
//        Assert.assertEquals("Status field value does not match", "ok", response.jsonPath().getString("status"));
//        logger.pass("Status field value matches 'ok'");
//
//        // Define expected values using HashMap
//        Map<String, Object> expectedValues = new HashMap<>();
//        expectedValues.put("data.userInfo.installationId", 242);
//        expectedValues.put("data.userInfo.installationName", "SATZ");
//        expectedValues.put("data.userInfo.timezoneId", 63);
//        expectedValues.put("data.userInfo.timezone", "South Africa Standard Time (UTC+02:00)");
//        expectedValues.put("data.userInfo.surveyDate", "04/13/2024 00:00:00");
//        expectedValues.put("data.userInfo.userName", "satz");
//        expectedValues.put("data.userInfo.email", "sunilpostman2022@gmail.com");
//        expectedValues.put("data.userInfo.firstName", "SATZ");
//        expectedValues.put("data.userInfo.lastName", "SATZ");
//        expectedValues.put("data.userInfo.supplier", "duracell energy");
//        expectedValues.put("data.userInfo.languageId", 1);
//
//        // Validate each key-value pair
//        expectedValues.forEach((key, expectedValue) -> {
//            Object actualValue = response.jsonPath().get(key);
//            Assert.assertEquals(String.format("%s does not match", key), expectedValue, actualValue);
//            logger.pass(String.format("%s matches the expected value", key));
//        });
//
//        // Validate token and roles
//        String token = response.jsonPath().getString("data.userInfo.token");
//        Assert.assertNotNull("Token is null", token);
//        logger.pass("Token is present");
//
//        List<Integer> roles = response.jsonPath().getList("data.userInfo.roles");
//        Assert.assertNotNull("Roles list is null", roles);
//        Assert.assertEquals("Roles do not match", List.of(1), roles);
//        logger.pass("Roles match expected values");
//
//        // Validate token expiry format
//        String tokenExpiry = response.jsonPath().getString("data.userInfo.tokenExpiry");
//        Assert.assertNotNull("Token expiry is null", tokenExpiry);
//        logger.pass("Token expiry is present");
//    }
//
//
//
//    @Then("status code should equal to {string}")
//    public void validateStatusCode(String statusCode) {
//        response.then().statusCode(Integer.parseInt(statusCode));
//        logger.pass(statusCode + " is the actual status code validated successfully");
//    }
//
//    @Then("user validate response with JSONPath {string} and value {string}")
//    public void validateResponseWithJsonPath(String jsonPath, String expectedValue) {
//        response.then().body(jsonPath, equalTo(expectedValue));
//        logger.pass(jsonPath + " validated response: " + expectedValue);
//    }
//
//    @And("request file {string}")
//    public void loadRequestFile(String fileName) throws IOException {
//        jsonData = Files.readString(Paths.get(System.getProperty("user.dir") + "/src/test/resources/Request/" + fileName));
//    }
//
//    @And("request file {string} and use data {string}, {string}, {string}")
//    public void loadAndModifyRequestFile(String fileName, String name, String year, String price) throws IOException {
//        jsonData = Files.readString(Paths.get(System.getProperty("user.dir") + "/src/test/resources/Request/" + fileName));
//        jsonData = jsonData.replace("{name}", name).replace("%year%", year).replace("%price%", price);
//    }
//
//    @And("user perform {string} operation")
//    public void performOperation(String operation) {
//        RequestSpecification requestSpec = RestAssured.given()
//                .contentType(ContentType.JSON)
//                .body(requestBody);
//
//        if (operation.equalsIgnoreCase("post")) {
//            response = requestSpec.post(endpoint);
//        } else if (operation.equalsIgnoreCase("put")) {
//            response = requestSpec.put(endpoint);
//        } else {
//            throw new IllegalArgumentException("Unsupported operation: " + operation);
//        }
//
//        response.prettyPrint();
//        logger.info("Successfully performed " + operation + " operation");
//    }
//
////    @Given("user send the post request with {string} and {string}")
////    public void sendPostRequestWithCredentials(String username, String password) {
////        JSONObject requestBody = new JSONObject();
////        requestBody.put("username", username);
////        requestBody.put("password", password);
////
////        response = RestAssured.given()
////                .header("Content-Type", "application/json")
////                .body(requestBody.toString())
////                .post(endpoint);
////
////        response.prettyPrint();
////        logger.pass("Validated post endpoint response");
////    }
//
//    @When("I set the request body with:")
//    public void setRequestBodyWith(String bodyTemplate) {
//        faker = new Faker();
//        requestBody = bodyTemplate.replace("<name>", faker.name().title())
//                .replace("<price>", String.valueOf(faker.number().randomDouble(2, 200, 2000)))
//                .replace("<year>", String.valueOf(faker.number().numberBetween(2020, 2050)));
//
//        logger.info("Successfully set random data in request body");
//    }
//    @Then("user validate response for locked account due to {int} successive attempts")
//    public void user_validate_response_for_locked_account_due_to_successive_attempts(Integer int1) {
//        String exptCode = response.getBody().jsonPath().getString("data.code");
//        String exptmsg = response.getBody().jsonPath().getString("data.msg");
//        String status = response.getBody().jsonPath().getString("status");
//        Assert.assertEquals("Code for locked user not match","LOCK_USER",exptCode);
//        logger.pass("For locked user actual code is "+exptCode+" matched with actual code.");
//        Assert.assertEquals("Msg for locked user not match","User Locked",exptmsg);
//        logger.pass("For locked user actual msg is "+exptmsg+" matched with actual msg.");
//        Assert.assertEquals("Status for locked user not match","fail",status);
//        logger.pass("For locked user actual status is "+status+" matched with actual status.");
//
//    }
//    }