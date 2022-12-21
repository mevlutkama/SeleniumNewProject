package tests.day08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Day08_Actions1_ extends TestBase {
    /*
        Given
                Go to "https://the-internet.herokuapp.com/context_menu"
        When
                Right click on the box
        Then
                Verify the alert message is “You selected a context menu”
        And
                Accept the alert
    */

    @Test
    public void rightclickTest() throws InterruptedException {

        // Go to "https://the-internet.herokuapp.com/context_menu"
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Right click on the box
        // 1.Step: Create "actions" object
        Actions actions = new Actions(driver);

        // 2.Step: Locate the web element you want to right-click
        WebElement box = driver.findElement(By.id("hot-spot"));

        // 3.Step: Use actions object with proper method.
        actions.contextClick(box).perform();

        // Verify the alert message is “You selected a context menu”
        Thread.sleep(2000);
        String alertText = driver.switchTo().alert().getText();
        assertEquals("You selected a context menu", alertText);

        // Accept the alert
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
