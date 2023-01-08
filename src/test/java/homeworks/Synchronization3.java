package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.*;

public class Synchronization3 extends TestBase {
    // Create a class:Synchronization3. Create a method: isEnabled
    // Go to https://the-internet.herokuapp.com/dynamic_controls
    // Click enable Button
    // And verify the message is equal to “It's enabled!”
    // And verify the textbox is enabled (I can type in the box)
    // And click on Disable button
    // And verify the message is equal to “It's disabled!”
    // And verify the textbox is disabled (I cannot type in the box)
    // NOTE: .isEnabled(); is used to check if an element is enabled or not

    @Test
    public void isEnabled(){
        // Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Click enable Button
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        // And verify the message is equal to “It's enabled!”
        WebElement enabled = driver.findElement(By.xpath("//p[@id='message']"));
        String enabledText = waitForVisibility(enabled,5).getText();
        assertEquals("It's enabled!",enabledText);

        // And verify the textbox is enabled (I can type in the box)
        boolean isEnabled = driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled();
        assertTrue(isEnabled);

        // And click on Disable button
        driver.findElement(By.xpath("//button[.='Disable']")).click();

        // And verify the message is equal to “It's disabled!”
        WebElement disabled = driver.findElement(By.xpath("//p[@id='message']"));
        String disabledText = waitForVisibility(disabled,5).getText();
        assertEquals("It's disabled!",disabledText);

        // And verify the textbox is disabled (I cannot type in the box)
        boolean isDisabled = driver.findElement(By.xpath("//form[@id='input-example']//input")).isEnabled();
        assertFalse(isDisabled);
    }
}
