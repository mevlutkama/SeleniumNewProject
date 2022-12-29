package tests.day11;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day11_ExtentReports extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetUp(){
        // REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

        // Creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // Creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

        // ***************

        // Adding custom System Info
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("SQA","John Fox");
        extentReports.setSystemInfo("Sprint Number", "SP205");

        // Adding more custom info
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");

        // ********************

        // DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter);

        // SUMMARY: Extent Reports and Extent HTML Reporter is used to add custom information on the report and create the report in a path

        // REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE

        // Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");
    }

    @Test
    public void extentReportsTest(){

        driver.get("https://techproeducation.com/");
        extentTest.pass("User is on TechPro Education Home Page");

        // Click on LMS
        driver.findElement(By.linkText("LMS LOGIN")).click();
        extentTest.pass("User is on LMS home page");

        // Verify the URL
        String expectedURL = "https://lms.techproeducation.com/";
        String actualURL = driver.getCurrentUrl();

        extentTest.pass("Asserting the LMS URL");
        Assert.assertEquals("LMS LOGIN page is not displayed", expectedURL, actualURL);
        extentTest.pass("TEST IS COMPLETE");
    }

    @Test
    public void extentReportsTest2(){
        // pass is used to mark the step as PASSED
        extentTest.pass("PASS");

        // info is used to just give an information for that step
        extentTest.info("INFO");

        // fail is used to mark the step as FAILED
        extentTest.fail("FAILED");

        // skip is used to mark the step as SKIPPED
        extentTest.skip("SKIPPED");

        // warning is used to give working information
        extentTest.warning("WARNING");
    }

    @AfterClass
    public static void extentReportsTearDown(){
        // Generating the report
        extentReports.flush();
    }
}
