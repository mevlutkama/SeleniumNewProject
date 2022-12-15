package tests.day04;

import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day04_LinkTexts_ {

    // Go to https://techproeducation.com/
    // Locate the LMS LOGIN with link text
    // Click on LMS LOGIN,
    // Assert that LMS page is visible

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void LMSPage(){
        // Go to https://techproeducation.com/
        driver.get("https://techproeducation.com/");

        // Locate the LMS LOGIN with link text
        // Click on LMS LOGIN
        driver.findElement(By.linkText("LMS LOGIN")).click();// linkText() method is case sensitive

        // Assert that LMS page is visible
        String expectedUrl = "https://lms.techproeducation.com/";
        String actualUrl = driver.getCurrentUrl();

        assertEquals("LMS page is 'NOT' visible",expectedUrl,actualUrl);
    }

    @Test
    public void LMSPagePartialLinkText(){
        // Go to https://techproeducation.com/
        driver.get("https://techproeducation.com/");

        // Locate the LMS LOGIN with partialLinkText
        // Click on LMS LOGIN
        driver.findElement(By.partialLinkText("LMS LO")).click();

        // Assert that LMS page is visible
        WebElement loginRegisterLink = driver.findElement(By.linkText("Login/Register"));
        assertTrue(loginRegisterLink.isDisplayed());// isDisplayed() method returns true if the element is displayed on the page otherwise it returns false.

        boolean isDisplayed = driver.findElement(By.className("dn-lg")).isDisplayed();
        assertTrue(isDisplayed);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
