package com.project.Crio_Playground.stepdefinitions;

import com.project.Crio_Playground.stepdefinitions.BaseSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class leadSteps extends BaseSteps {



    @When("user enter the mandatories fields and click on save button")
    public void user_enter_the_mandatories_fields_and_click_on_save_button(io.cucumber.datatable.DataTable dataTable) {
       List<Map<String,String>> lst =  dataTable.entries();
       for(int i=0;i<lst.size();i++)
       {
//           getLeadPage().ClickNewLead();
//           getLeadPage().createlead(lst.get(i).get("lastname"),lst.get(i).get("company"));
       }
    }
    @Then("lead should be created successfully")
    public void lead_should_be_created_successfully() {

    }
}
