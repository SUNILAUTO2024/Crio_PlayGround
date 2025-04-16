package com.Crio_Playground.pages;

import com.aventstack.extentreports.ExtentTest;
import com.project.Crio_Playground.utility.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends PageActions {

    public AccountPage(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        PageFactory.initElements(driver,this);
    }
//
//    @FindBy(xpath = "//input[@name='accountname']")
//    WebElement tb_accountname;
//
//    @FindBy(name = "button")
//    WebElement btn_save;
//
//    public void createAccount(String acc)
//    {
//        System.out.println("testing code");
//        SetAccountName(acc);
//        clickSave();
//    }
//
//    public void SetAccountName(String acc)
//    {
//        SetInput(tb_accountname,acc,acc+" has been entered successfully into account name field");
//    }
//
//    public void clickSave()
//    {
//        ClickElement(btn_save,"Save button clicked");
//    }
}
