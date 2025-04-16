package com.project.Crio_Playground.pages;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import com.project.Crio_Playground.utility.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageActions {



    public HomePage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
        PageFactory.initElements(driver, this);
    }

}




