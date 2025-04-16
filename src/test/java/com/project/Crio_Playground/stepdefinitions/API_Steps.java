package com.project.Crio_Playground.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

//import static com.vtiger.stepdefinitions.BaseSteps.prop;

public class API_Steps extends BaseSteps {
    public String Endpoint;
    public Response resp;

//    @Before
//    public void getScenarioName(Scenario scenario) throws FilloException, IOException {
//        if(extent==null) {
//            initiation();
//        }
//        ScenarioName = scenario.getName();
//        logger = extent.createTest(ScenarioName);
//    }
//    @After
//    public static void savereport() {
//        if (driver != null) {
//            driver.quit();  // Use quit instead of close
//        }
//        extent.flush();
//    }


    @Given("endpoint")
    public void endpoint() {
        System.out.println(prop.getProperty("Base_URL")+APItd.get(ScenarioName).get("Endpoint"));
        Endpoint=prop.getProperty("Base_URL")+APItd.get(ScenarioName).get("Endpoint");

    }
    @When("user send get request")
    public void user_send_get_request() {
    resp = RestAssured.get(Endpoint);
        //System.out.println(resp.getStatusLine());
    }
    @Then("status code should be {int}")
    public void status_code_should_be(Integer int1) {
        System.out.println(resp.getStatusLine());
        System.out.println(resp.prettyPrint());


        for(Map.Entry<String,String> innerEntry:APItd.get(ScenarioName).entrySet()){
            //if(innerEntry)

        }


    }
    @When("total records should be {int}")
    public void total_records_should_be(Integer int1) {

    }






}
