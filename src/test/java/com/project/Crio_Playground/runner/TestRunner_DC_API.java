package com.duracell.API.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "com.vtiger.stepdefinitions",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"},
        tags = "@Battery_regi",
        monochrome = true
)
public class TestRunner_DC_API {
}
