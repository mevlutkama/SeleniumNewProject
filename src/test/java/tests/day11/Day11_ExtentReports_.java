package tests.day11;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Day11_ExtentReports_ extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetUp(){
        // Create Report Path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// getting the current local date and time
        String path = System.getProperty("user.dir") + "/test-output/Reports/" + currentTime + ".html";

        // Create HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // Create extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

        // Add custom System Info
        extentReports.setSystemInfo("Test Environment", "Smoke Test");
        extentReports.setSystemInfo("Application", "TechProEducation");
        extentReports.setSystemInfo("Team", "RedBulls");
        extentReports.setSystemInfo("SQA", "John Doe");
        extentReports.setSystemInfo("Sprint Number", "SP205");

        // Add more custom config info
        extentHtmlReporter.config().setReportName("TechPro Education LMS");
        extentHtmlReporter.config().setDocumentTitle("TechPro Education Extent Reports");

        // Done With Configuration(attach Reporter)
        extentReports.attachReporter(extentHtmlReporter);

        // SUMMARY: extentReports and extentHtmlReporter are used to add custom information on the report and create the report in a PATH

        // Create extent test
        extentTest = extentReports.createTest("Extent Reporter","This is my Smoke Test Report");
    }

    @Test
    public void ExtentReportTest1(){
        // Use reports
        driver.get("https://techproeducation.com/");
        extentTest.pass("User is on TechPro Education Homepage");

        // Go to LMS
        driver.findElement(By.linkText("LMS LOGIN")).click();
        extentTest.pass("User is on LMS Homepage");

        // Verify the Url
        String lmsUrl = driver.getCurrentUrl();
        assertEquals("https://lms.techproeducation.com/", lmsUrl);
        extentTest.pass("Url assertion is done");
    }

    @Test
    public void extentReportTest2(){
        // pass is used to mark the step as PASSED
        extentTest.pass("PASS");

        // info is used to give an information for the step
        extentTest.info("INFORMATION");

        // fail is used to mark the step as FAILED
        extentTest.fail("FAIL");

        // skip is used to mark the step as SKIPPED
        extentTest.skip("SKIPPED");

        // warning is used to give working information
        extentTest.warning("WARNING");
    }

    @AfterClass
    public static void extentReportTearDown(){
        // Generate the report
        extentReports.flush();
    }
}
