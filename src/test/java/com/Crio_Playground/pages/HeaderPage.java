package com.Crio_Playground.pages;

import com.aventstack.extentreports.ExtentTest;
//import com.vtiger.utility.PageActions;

import com.project.Crio_Playground.utility.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends PageActions {

    public HeaderPage(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Logout")
    WebElement lnk_logout;

    @FindBy(linkText = "New Lead")
    WebElement lnk_NewLead;

    @FindBy(linkText = "Leads")
    WebElement lnk_leads;

    @FindBy(linkText = "Home")
    WebElement lnk_Home;

    @FindBy(linkText = "New Account")
    WebElement lnk_NewAccount;

    @FindBy(linkText = "New Contact")
    WebElement New_Contact;


    public void verifyHome()
    {
        ElementExist(lnk_Home,"Link Home is displayed on home page");
    }

    public void verifyLogout()
    {
        ElementExist(lnk_logout,"Link Logout is displayed on Home page");
    }

    public void ClickLogout()
    {
        ClickElement(lnk_logout,"Link Logout clicked successfully");
    }

    public void ClickNewLead()
    {
        ClickElement(lnk_NewLead,"Link New Lead clicked successfully");
    }

    public void ClickLeads()
    {
        ClickElement(lnk_leads,"Link Leads clicked successfully");
    }

    public void ClickNewAccount()
    {
        ClickElement(lnk_NewAccount,"Link New Account clicked successfully");
    }

    public void clickNContact() {

        ClickElement(New_Contact," Successfully clicked on New Contact link");
    }

}
