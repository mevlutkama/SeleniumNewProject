package tests.day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Day14_ExplicitWait_ extends TestBase {

    /*
    Given
        Go to https://the-internet.herokuapp.com/dynamic_loading/1
    When
        User clicks on the "Start" button
    Then
        Assert the "Hello World!" Shows up on the screen
     */

    @Test
    public void explicitWaitTest(){

        // Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // User clicks on the "Start" button
        driver.findElement(By.xpath("//button[.='Start']")).click();

        // Assert the "Hello World!" Shows up on the screen
        // String helloWorldText = driver.findElement(By.xpath("//h4[.='Hello World!']")).getText();
        // assertEquals("Hello World!",helloWorldText);

        // Implicit Wait could not handle the waiting issue. We will try Explicit Wait
        // 1.Step: Create web driver object
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // 2.Step: Use wait object to handle the waiting issue (synchronization)
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));
        assertEquals("Hello World!",helloWorld.getText());
    }

    @Test
    public void explicitWaitTestReusable(){

        // Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // User clicks on the "Start" button
        driver.findElement(By.xpath("//button[.='Start']")).click();

        // Assert the "Hello World!" Shows up on the screen
        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        String helloWorldString = waitForVisibility(helloWorld,10).getText();
        assertEquals("Hello World!",helloWorldString);
    }
}
