package tests.day14;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Day14_ExplicitWait extends TestBase {
    @Test
    public void explicitWaitTest(){
        // Create a class:ExplicitWait
        // Create a method: explicitWait

        // Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        // Then verify the ‘Hello World!’ Shows up on the screen
        // This piece of code fails cause implicit wait is not able to handle the wait time
        // Solition: Try explicit wait or fluent wait
        // WebElement helloElement = driver.findElement(By.xpath("//div[@id='finish']//h4")));
        // Assert.assertEquals("Hello World!", helloElement.getText());

        // 1. Create webdriver wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 2. Use wait object to handle synchronization issue(wait issue)
        // waits for the xpath to be visible up to 10 seconds
        // returns the WebElement
        // If the element is not found within 10 seconds, throw time out exception
        WebElement helloElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!", helloElement.getText());
    }

    @Test
    public void explicitWaitReusable(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        WebElement helloElement = waitForClickablility(By.xpath("//div[@id='finish']//h4"),10);
        Assert.assertEquals("Hello World!", helloElement.getText());
    }
}
