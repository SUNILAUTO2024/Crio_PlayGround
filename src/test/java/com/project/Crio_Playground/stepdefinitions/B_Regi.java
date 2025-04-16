//package com.duracell.API.stepdefinitions;
//
//import com.duracell.Android.stepdefinitions.BaseSteps;
//import com.github.javafaker.Faker;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.json.JSONObject;
//import org.junit.Assert;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//
//public class B_Regi extends BaseSteps {
//
//    private static final Log log = LogFactory.getLog(B_Regi.class);
//    private static String endpoint;
//    private static String enddp_Battrey_regi;
//    private static Response resp;
//    private static String token;
//    private static Faker faker;
//    private static JSONObject reqBody;
//    private static int product1;
//    private static int product2;
//    private static String name1;
//    private static String enddp_install_list;
//    private static int Inst_ID;
//
//    @When("user send the post request with uid and psd & set endpoints")
//    public void sendPostRequestWithCredenttials() {
//        try {
//            enddp_Battrey_regi = prop.getProperty("Base_URL_PD") + prop.getProperty("B_regi");
//            enddp_install_list = prop.getProperty("Base_URL_PD") + prop.getProperty("install_list");
//
//            JSONObject requestBody = new JSONObject();
//            requestBody.put("username", APItd.get(ScenarioName).get("Userid"));
//            requestBody.put("password", APItd.get(ScenarioName).get("Password"));
//
//            endpoint = prop.getProperty("Base_URL_PD") + prop.getProperty("authenticate");
//
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(requestBody.toString())
//                    .post(endpoint);
//
//            logger.pass("Authentication POST request sent successfully.");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request for authentication: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @When("Set token Global")
//    public void set_token_global_and_endpoint_for_B_regi() {
//        try {
//            token = resp.jsonPath().getString("data.userInfo.token");
//            logger.info("Token set globally: " + token);
//        } catch (Exception e) {
//            logger.fail("Failed to set global token: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Then("send Post request with Blank product & valid token")
//    public void send_post_blank_product_request_with_valid_token() {
//        try {
//            faker = new Faker();
//            name1 = faker.name().firstName();
//            reqBody = new JSONObject();
//            reqBody.put("product", "");
//            reqBody.put("supplier", "duracell energy");
//            reqBody.put("address", faker.address().cityName());
//            reqBody.put("postcode", "12321");
//            reqBody.put("name", name1);
//            reqBody.put("email", "abcd@gmail.com");
//            reqBody.put("timezoneID", "63");
//            reqBody.put("languageid", 1);
//
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(reqBody.toString())
//                    .post(enddp_Battrey_regi);
//
//            logger.pass("POST request sent successfully for Battery registration.");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request for Battery registration: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    public void s_Code_200() {
//        try {
//            int expectedStatus = 200;
//            int actualStatus = resp.statusCode();
//            Assert.assertEquals(expectedStatus, actualStatus);
//            logger.pass("Expected status code " + expectedStatus + " matches with actual status code " + actualStatus);
//        } catch (AssertionError e) {
//            logger.fail("Status code validation failed: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Then("validate status code of response")
//    public void validate_status_code_response() {
//        try {
//            s_Code_200();
//        } catch (Exception e) {
//            logger.fail("Failed to validate status code of the response: " + e.getMessage());
//            throw e;
//        }
//    }
//    @Then("validate response for all unique values")
//    public void validate_response_for_all_unique_values() {
//        try {
//            resp.prettyPrint();
//            String data = resp.getBody().jsonPath().getString("data");
//            String status = resp.getBody().jsonPath().getString("status");
//
//            resp.then()
//                    .body("data", equalTo(null))
//                    .body("status", equalTo("ok"));
//
//            logger.pass("Validated response with status: " + status);
//            logger.pass("Validated response data: " + data);
//            logger.pass(APItd.get(ScenarioName) + " - Scenario passed.");
//        } catch (Exception e) {
//            logger.fail("Response validation failed for all unique values : " + e.getMessage());
//            throw e;
//        }
//    }
//    @Then("validate response with duplicate name")
//    public void validate_response_duplicate_name() {
//        try {
//            resp.prettyPrint();
//            String msg = resp.getBody().jsonPath().getString("data.msg");
//            String status = resp.getBody().jsonPath().getString("status");
//
//            resp.then()
//                    .body("data.msg", equalTo("Duplicate Installation"))
//                    .body("status", equalTo("fail"));
//
//            logger.pass("Validated response with status: " + status);
//            logger.pass("Validated response error: " + msg);
//            logger.pass(APItd.get(ScenarioName) + " - Scenario passed.");
//        } catch (Exception e) {
//            logger.fail("Response validation failed for duplicate name values : " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Then("validate response with duplicate Product id")
//    public void validate_response_duplicate_product() {
//        try {
//            resp.prettyPrint();
//            String msg = resp.getBody().jsonPath().getString("data.msg");
//            String status = resp.getBody().jsonPath().getString("status");
//
//            resp.then()
//                    .body("data.msg", equalTo("Duplicate Inverter ID"))
//                    .body("status", equalTo("fail"));
//
//            logger.pass("Validated response with status: " + status);
//            logger.pass("Validated response error: " + msg);
//            logger.pass(APItd.get(ScenarioName) + " - Scenario passed.");
//        } catch (Exception e) {
//            logger.fail("Response validation failed for Duplicate Inverter ID : " + e.getMessage());
//            throw e;
//        }
//    }
//    @Then("validate details in response of search result and set installation id global")
//    public void validate_response_search_result() {
//        try {
//            resp.prettyPrint();
//            Inst_ID= Integer.parseInt(resp.getBody().jsonPath().getString("id[0]"));
//            String batteryProduct = resp.getBody().jsonPath().getString("batteryProduct[0]");
//           String name = resp.getBody().jsonPath().getString("name[0]");
//
//           resp.then()
//                  .body(batteryProduct, equalTo(product1))
//                 .body(name, equalTo(name1));
//
//            logger.pass("Validated response with batteryProduct : " + batteryProduct);
//            logger.pass("Validated response name : " + name);
//            logger.pass(APItd.get(ScenarioName) + " - Scenario passed.");
//        } catch (Exception e) {
//            logger.fail("Response validation failed for Duplicate Inverter ID : " + e.getMessage());
//            throw e;
//        }
//    }
//
//
//    @Then("validate response for Blank product")
//    public void validate_response_for_blank_product() {
//        try {
//            resp.prettyPrint();
//            String status = resp.getBody().jsonPath().getString("status");
//            String errorMsg = resp.getBody().jsonPath().getString("data.msg");
//
//            resp.then()
//                    .body("data.code", equalTo("EMPTY_INVERTER_ID"))
//                    .body("data.msg", equalTo("Inverter ID cannot be empty"))
//                    .body("status", equalTo("fail"));
//
//            logger.pass("Validated response with status: " + status);
//            logger.pass("Validated response message: " + errorMsg);
//            logger.pass(APItd.get(ScenarioName) + " - Scenario passed.");
//        } catch (Exception e) {
//            logger.fail("Response validation failed for Blank product: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Then("send Post request with space as a product & valid token")
//    public void send_post_request_with_space_as_a_product_valid_token() {
//        try {
//            reqBody.remove("product");
//            reqBody.put("product", " ");
//
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(reqBody.toString())
//                    .post(enddp_Battrey_regi);
//
//            logger.pass("POST request sent successfully for Battery registration with product as space.");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request with product as space: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Then("send Post request with space in a product & valid token")
//    public void send_post_request_with_space_in_a_product_valid_token() {
//        try {
//            reqBody.remove("product");
//            reqBody.put("product", "test test");
//
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(reqBody.toString())
//                    .post(enddp_Battrey_regi);
//
//            logger.pass("POST request sent successfully for Battery registration with product as 'test test'.");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request with product as 'test test': " + e.getMessage());
//            throw e;
//        }
//    }
//
//    public static void main(String[] args) {
//        RestAssured.baseURI="https://reqres.in";
//        Response res = RestAssured.given().request(Method.GET,"/api/users?page=3");
//        //res.prettyPrint();
//       // Assert.assertEquals("validating response",);
//        reqBody=new JSONObject();
//        reqBody.put("name","tesr").put("job","abcd");
//        Response res2=RestAssured.given().body(reqBody).request(Method.POST,"/api/users");
//        res2.prettyPrint();
//        String id = res2.body().jsonPath().getString("id");
//      //  reqBody.("name");reqBody.put("",)
//      //  res=RestAssured.given().body()
//
//    }
//
//    @Then("send Post request with unique values & valid token")
//    public void send_Post_request_with_unique() {
//        try {
//            faker = new Faker();
//             product1 = faker.number().numberBetween(55,98596485);
//
//            reqBody.remove("product");
//            reqBody.put("product", product1);
//
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(reqBody.toString())
//                    .post(enddp_Battrey_regi);
//
//            logger.info(product1+" use this unique product id");
//            logger.info(name1+" use this unique name");
//
//            logger.pass("POST request sent successfully for Battery registration with all unique values");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request with all unique values as = " + e.getMessage());
//            throw e;
//        }
//    }
//    @Then("send Post request with unique values & to register EV1")
//    public void send_Post_request_with_unique_regi_EV1_Existing_site() {
//        try {
//            reqBody = new JSONObject();name1 = faker.name().firstName();
//            faker = new Faker();product1 = faker.number().numberBetween(55,98596485);
//
//            reqBody.put("product1", product1).put("charger1Name", name1);
//            reqBody.put("installationId",Inst_ID).put("chargerNo",1).put("supplier","duracell Energy");
//
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(reqBody.toString())
//                    .post(enddp_Battrey_regi);
//
//            logger.info(product1+" use this unique product id");
//            logger.info(name1+" use this unique name");
//
//            logger.pass("POST request sent successfully for Battery registration with all unique values");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request with all unique values as = " + e.getMessage());
//            throw e;
//        }
//    }
//    @Then("send Post request with duplicate Product id & valid token")
//    public void send_Post_request_with_duplicate_Product() {
//        try {
//         //   reqBody.remove("product");reqBody.put("product", product1);
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(reqBody.toString())
//                    .post(enddp_Battrey_regi);
//            logger.info(product1+" use this duplicate product id");
//            logger.info(name1+" use this unique name");
//
//            logger.pass("POST request sent successfully for Battery registration with duplicate product");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request with duplicate product as = " + e.getMessage());
//            throw e;
//        }
//    }
//    @Then("search Post request with recently regi. product id in list endpoint")
//    public void Search_product_newly_regi() {
//        try {
//            reqBody = new JSONObject();
//            reqBody.put("filter", product1);
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(reqBody.toString())
//                    .post(enddp_install_list);
//            logger.info(product1+" use this to search installation");
//
//            logger.pass("POST request sent successfully for Searching product with product");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request for Searching product id = " + e.getMessage());
//            throw e;
//        }
//    }
//
//
//
//    @Then("send Post request with duplicate Name & valid token")
//    public void send_Post_request_with_duplicate_Name() {
//        try {
//            product2= faker.number().numberBetween(121,1111111);
//            reqBody.remove("product");reqBody.put("product", product2);
//
//            resp = RestAssured.given()
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + token)
//                    .body(reqBody.toString())
//                    .post(enddp_Battrey_regi);
//
//            logger.info(product1+" use this unique product ");
//            logger.info(name1+" use this duplicate name");
//
//            logger.pass("POST request sent successfully for Battery registration with duplicate name");
//        } catch (Exception e) {
//            logger.fail("Failed to send POST request with duplicate name as = " + e.getMessage());
//            throw e;
//        }
//    }
//
//
//    @Then("validate response for space in product")
//    public void validate_response_for_space_in_product() {
//        try {
//            resp.prettyPrint();
//            String status = resp.getBody().jsonPath().getString("status");
//            String errorMsg = resp.getBody().jsonPath().getString("data.msg");
//
//            resp.then()
//                    .body("data.code", equalTo("BAD_INVERTER_ID"))
//                    .body("data.msg", equalTo("Invalid Inverter ID"))
//                    .body("status", equalTo("fail"));
//
//            logger.pass("Validated response with status: " + status);
//            logger.pass("Validated response message: " + errorMsg);
//            logger.pass(APItd.get(ScenarioName) + " - Scenario passed.");
//        } catch (Exception e) {
//            logger.fail("Response validation failed for product with spaces: " + e.getMessage());
//            throw e;
//        }
//    }
//}
