package tests.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day03_Locators_ {
    /*
            User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
            Locate the elements of Username textbox, Password textbox, and Login button
            Enter below username and password then click on login button
                Username :  Admin
                Password :  admin123
            Verify the login is successful
            Sign out from the page
        */

    WebDriver driver;

    @Before
    public void setUp(){
        // User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void loginTest(){

        // Locate the elements of Username textbox, Password textbox, and Login button
        WebElement usernameTextBox = driver.findElement(By.name("username"));
        WebElement passwordTextBox = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.tagName("button"));

        // Enter below username and password then click on login button
        //                Username :  Admin
        //                Password :  admin123

        usernameTextBox.sendKeys("Admin");
        passwordTextBox.sendKeys("admin123");
        loginButton.click();

        // Assert the login is successful
        // 1. We can use page url to do assertion
        // 2. We can use a specific element for the page for assertion

        // https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index ==> Current Url
        boolean actualValue = driver.getCurrentUrl().contains("dashboard");
        assertTrue(actualValue);

        // Note: We do not need to use containers for web elements. We can use method chain for actions.
        // driver.findElement(By.name("username")).sendKeys("Admin");
        // driver.findElement(By.tagName("button")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
