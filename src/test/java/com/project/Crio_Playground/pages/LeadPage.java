//package com.duracell.API.pages;
//
//import com.aventstack.extentreports.ExtentTest;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class LeadPage extends HeaderPage{
////    public LeadPage(WebDriver driver, ExtentTest logger) {
////        super(driver,logger);
////        PageFactory.initElements(driver,this);
////    }
//
//    @FindBy(xpath = "//input[@name='lastname']")
//    WebElement tb_lastname;
//
//    @FindBy(name = "company")
//    WebElement tb_company;
//
//    @FindBy(name = "button")
//    WebElement btn_save;
//
//    public void createlead(String lname,String comp)
//    {
//        SetLastName(lname);
//        SetCompany(comp);
//        clickSave();
//    }
//
//    public void SetLastName(String lname)
//    {
//        SetInput(tb_lastname,lname,lname+" has been entered into last name field");
//    }
//
//    public void SetCompany(String comp)
//    {
//        SetInput(tb_company,comp,comp+" has been entered successfully into company field");
//    }
//
//    public void clickSave()
//    {
//        ClickElement(btn_save,"Save button clicked");
//    }
//}
