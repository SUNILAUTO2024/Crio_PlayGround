package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HomeStep {
    WebDriver driver;

@Before
    @Given("Opens Home page")
    public void opens_home_page() {
        driver = new ChromeDriver();
        driver.get("https://web-locators-static-site-qa.vercel.app/");
    }
@Test
    @Then("verify Header and logo")
    public void verify_header_and_logo() {

        WebElement Header = driver.findElement(By.xpath("//div[@class='homeScreen-header__heading']"));
        if (Header.isDisplayed()) {
            System.out.println(Header.getText() + " is exists in Home page");
        }
        System.out.println("Page title = " + driver.getTitle());
        WebElement logo = driver.findElement(By.xpath("//img[@alt='icon']"));
        if (logo.isDisplayed()) {
            System.out.println("Logo exists and is displayed");
        }
    }
@Test
    @Then("check tabs appears and validate titles of each")
    public void check_tabs_appears_and_validate_titles() {
        List<String> tab_Title = new LinkedList<>();
        // Add all expected tab titles
        tab_Title.add("Edit");tab_Title.add("Button");tab_Title.add("Hyperlink");tab_Title.add("Image");tab_Title.add("Dropdown");tab_Title.add("Radio");
        tab_Title.add("Checkbox");tab_Title.add("Calendar");tab_Title.add("Auto-complete");tab_Title.add("Upload");tab_Title.add("Web Table");tab_Title.add("Alerts");
        tab_Title.add("Frames");tab_Title.add("Windows");tab_Title.add("Wait onTime");tab_Title.add("Wait onClick");tab_Title.add("Wait onScroll");
        tab_Title.add("Captcha");tab_Title.add("Mouse");tab_Title.add("Keyboard Operations");tab_Title.add("Screenshot");

        // Find all tab elements from the UI
        List<WebElement> Tabs = driver.findElements(By.className("cardHeading"));
        System.out.println("Expected Tabs: " + tab_Title.size());
        System.out.println("Actual Tabs: " + Tabs.size());

        // Validate each element text
        for (int i = 0; i < Tabs.size(); i++) {
            String actualText = Tabs.get(i).getText().trim();
            String expectedText = tab_Title.get(i);
            System.out.println("Expected: " + expectedText + " | Actual: " + actualText);
            if (!actualText.equals(expectedText)) {
                System.out.println("❌ Mismatch at index " + i);
            } else {
                System.out.println("✅ Match");
            }
        }
    }
}

