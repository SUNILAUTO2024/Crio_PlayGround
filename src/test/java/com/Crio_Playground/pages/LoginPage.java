package com.Crio_Playground.pages;

import com.aventstack.extentreports.ExtentTest;


import com.project.Crio_Playground.utility.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageActions {


    public WebDriver driver;

    public LoginPage(WebDriver driver, ExtentTest logger)
    {
        super(driver,logger);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*
    String username = "//input[@name='user_name']";
    String userpassword = "user_password";
    String login = "Login";


    By username = By.xpath("//input[@name='user_name']");
    By password = By.name("user_password");
    By login = By.name("Login");
*/

    @FindBy(xpath = "//input[@name='user_name']")
    WebElement tb_username;

    @FindBy(name = "user_password")
    WebElement tb_password;

    @FindBy(name = "login_theme")
    WebElement dp_theme;

    @FindBy(name = "Login")
    WebElement btn_login;

    @FindBy(xpath = "//img[@src='include/images/vtiger-crm.gif']")
    WebElement img_logo;

    @FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password.')]")
    WebElement txt_errMsg;




    public void login(String uid,String pwd)
    {
        System.out.println("hello");
        SetUserName(uid);
        SetPassword(pwd);
        clickLogin();
    }

    public void login(String uid,String pwd,String theme)
    {
        SetUserName(uid);
        SetPassword(pwd);
        selectTheme(theme);
        clickLogin();
    }

    public void SetUserName(String uid)
    {
        SetInput(tb_username,uid,uid+" has been entered into username field");
    }

    public void SetPassword(String pwd)
    {
        SetInput(tb_password,pwd,pwd+" has been entered into password field");
    }

    public void clickLogin()
    {
       ClickElement(btn_login,"login button clicked");
    }

    public void selectTheme(String themevalue)
    {
       SelectVisibleText(dp_theme,themevalue,themevalue+" has been selected from Theme dropdown");
    }

    public void verifyLogo()
    {
        ElementExist(img_logo,"Logo is displayed on login page");
    }

    public void verifyErrorMessage()
    {
        ElementExist(txt_errMsg,"Error message validate successfully");
    }








}
