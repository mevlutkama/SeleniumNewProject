package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class Synchronization2 extends TestBase {
    // Create a class:Synchronization2.
    // Create a method: synchronization2
    // Go to https://the-internet.herokuapp.com/dynamic_loading/2
    // When user clicks on the Start button
    // Then verify the ‘Hello World!’ Shows up on the screen

    @Test
    public void synchronization2(){
        // Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        // When user clicks on the Start button
        driver.findElement(By.xpath("//button[.='Start']")).click();

        // Then verify the ‘Hello World!’ Shows up on the screen
        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        String text = waitForVisibility(helloWorld,10).getText();
        System.out.println("text = " + text);
        assertEquals("Hello World!", text);
    }
}
