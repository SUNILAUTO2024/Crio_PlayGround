package com.project.Crio_Playground.utility;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class PageActions {

    public WebDriver driver;
    public WebDriverWait wait;
    public ExtentTest logger;

    public PageActions(WebDriver driver,ExtentTest logger)
    {
        this.driver = driver;
        this.logger = logger;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getScreenshot()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
        TakesScreenshot ts = ((TakesScreenshot)driver);

        File SrcFile=ts.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(path);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }
    public void Validate_title(WebElement elm, String actual_title,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            String exp_title=elm.getText();
            Assert.assertEquals(exp_title+ "is not matched with "+actual_title,exp_title,actual_title);
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to Validate_title due to error "+e.getMessage()+"   <a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }
    public void SetInput(WebElement elm, String value,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(value);
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to set Data into text field due to error "+e.getMessage()+"   <a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }

    public void SelectVisibleText(WebElement elm, String value,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            Select sel = new Select(elm);
            sel.selectByVisibleText(value);
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to select Data from dropdown field due to error "+e.getMessage()+"   <a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }

    public void ClickElement(WebElement elm,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable click on element due to error "+e.getMessage()+"   <a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }

    public void ElementExist(WebElement elm,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Element does not exist due to error "+e.getMessage()+"   <a href='"+getScreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
        }
    }


}
