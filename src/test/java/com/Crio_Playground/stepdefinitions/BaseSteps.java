package com.Crio_Playground.stepdefinitions;

import com.Crio_Playground.pages.PageObjectManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
//import com.vtiger.pages.PageObjectManager;
//import com.project.Crio_Playground.pages.PageObjectManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BaseSteps extends PageObjectManager {




    public static Properties prop;
    public static Map<String, Map<String,String>> td;
    public static String ScenarioName;
    public static Map<String, Map<String,String>> APItd;


    public void initiation() throws IOException, FilloException {
        createExtentReport();
        readproperties();
        td=readExcel(System.getProperty("user.dir")+"/src/test/resources/Data/PlayGround.xlsx","Test_Cases");
       //APItd = readExcel(System.getProperty("user.dir")+"/src/test/resources/Data/TestData.xlsx","Sheet2");
    }


    public void launchApp() throws Exception {

      readproperties();
        readExcel(System.getProperty("user.dir")+"/src/test/resources/Data/PlayGround.xlsx","Test_Cases");
      //  System.out.println(td);
        System.exit(0);
        if(prop.getProperty("browser").equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else  if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else
        {
            driver = new ChromeDriver();
        }
        System.out.println("launching driver");
        driver.get(prop.getProperty("Base_URL"));

    }

    public void readproperties() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
        prop.load(fis);
    }

    public void createExtentReport()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Test Hub");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Rajesh U");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        htmlReporter.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);

    }


    public Map<String, Map<String,String>> readExcel(String workbook, String sheet) throws FilloException {
         Map<String, Map<String,String>> td;
        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection(workbook);
        String strQuery = "Select * from "+sheet;
        Recordset recordset = connection.executeQuery(strQuery);
        ArrayList<String> lst = recordset.getFieldNames();

        td = new HashMap<>();

        while (recordset.next()) {

            Map<String,String> rowdata = new HashMap<>();
            for(String colm:lst)
            {
                rowdata.put(colm, recordset.getField(colm));
            }

            td.put(recordset.getField("ScenarioName"),rowdata);
        }
        recordset.close();
        connection.close();

        return td;
    }
}
