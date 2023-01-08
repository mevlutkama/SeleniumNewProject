package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Synchronization1 extends TestBase {

    // Create a class:Synchronization1. Create a method: synchronization1
    // Go to https://the-internet.herokuapp.com/dynamic_controls
    // Click on remove button
    // And verify the message is equal to “It's gone!”
    // Then click on Add button
    // And verify the message is equal to “It's back!”

    @Test
    public void synchronization1(){

        // Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Click on remove button
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        // And verify the message is equal to “It's gone!”
        WebElement message1 = driver.findElement(By.xpath("//p[@id='message']"));
        String text1 = waitForVisibility(message1,6).getText();
        System.out.println("text1 = " + text1);
        assertEquals("It's gone!",text1);

        // Then click on Add button
        driver.findElement(By.xpath("//button[.='Add']")).click();

        // And verify the message is equal to “It's back!”
        WebElement message2 = driver.findElement(By.xpath("//p[@id='message']"));
        String text2 = waitForVisibility(message2,6).getText();
        System.out.println("text2 = " + text2);
        assertEquals("It's back!",text2);
    }
}
