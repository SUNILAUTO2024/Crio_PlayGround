package com.Crio_Playground.pages;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.project.Crio_Playground.utility.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageActions {



    public HomePage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='homeScreen-header__heading']")
    WebElement Home_header;

    public void validate_Header(){
        Validate_title(Home_header,"Crio playground","Header page validated correctly");
    }
}




