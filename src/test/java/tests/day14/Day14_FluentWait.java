package tests.day14;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Day14_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        // Fluent Wait
        // 1.Creating Fluent Wait Object
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).// Total wait
                pollingEvery(Duration.ofSeconds(2)).// How often element will be checked
                withMessage("Ignoring No Such Element Acception").// Optional: Give Message
                ignoring(NoSuchElementException.class);// Optional: Ignore Exception

        // 2.Using wait object, apply wait. Same as explicit wait
        WebElement helloElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!",helloElement.getText());
    }

    @Test
    public void fluentTestReusable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        // reusable method that accepts the element and max time out as parameters
        WebElement helloElement = fluentWait("//div[@id='finish']//h4", 10, 3);
        Assert.assertEquals("Hello World!",helloElement.getText());
    }
}
