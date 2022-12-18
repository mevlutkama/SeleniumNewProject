package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// Create a new class : GoogleSearchTest
public class GoogleSearchTest {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // Create Test method and complete the following task.
    @Test
    public void test(){
        // When user goes to https://www.google.com/
        driver.get("https://www.google.com/");

        // Search for “porcelain teapot”
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("porcelain teapot");
        driver.findElement(By.xpath("//span[.='porcelain teapot']")).click();

        // And print how many related results displayed on Google
        String numOfRelatedResults = driver.findElement(By.id("result-stats")).getText();
        numOfRelatedResults = numOfRelatedResults.replaceAll("[^0-9]","");
        System.out.println("numOfRelatedResults = " + numOfRelatedResults);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
