package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "stepDef",
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"},
        tags = "@login",
        monochrome = false



)
public class Runner {
}
