package com.Crio_Playground.stepdefinitions;

import com.Crio_Playground.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.Crio_Playground.pages.PageObjectManager.driver;

public class Home_Step extends com.Crio_Playground.stepdefinitions.BaseSteps {


    @Then("Retrieve current url and validate")
    public void retrieve_current_url_and_validate() {
        hp.validate_Header();
    }
    @Then("Retrieve header & Logo and validate")
    public void retrieve_header_logo_and_validate() {

    }
}
