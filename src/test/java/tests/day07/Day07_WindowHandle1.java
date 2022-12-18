package tests.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Day07_WindowHandle1 extends TestBase {

    @Test
    public void windowHandleTest() throws InterruptedException {
        // Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        // Then user verifies the text : “Opening a new window”
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);

        // Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet",driver.getTitle());

        // Getting the window 1 handle(unique page id)
        String window1Handle = driver.getWindowHandle();// Returns the current window id
        System.out.println("window1Handle = " + window1Handle);

        // When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();

        // We do testing in a new window, so we must switch to that window
        // As of now 2 windows open. Use getWindowHandles() to get both id's
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);

        for (String eachHandle : allWindowHandles){// looping through the windows
            if (!eachHandle.equals(window1Handle)){// if we are not in windows 1 (means windows 2)
                driver.switchTo().window(eachHandle);// then switch the window 2
            }
        }

        // At this point driver is switched to windows 2

        String window2Handle = driver.getWindowHandle();// Window 2 id.
        // Then user verifies the text:  “New Window”

        // Then user verifies the window title is "New Window"
        Assert.assertEquals("New Window",driver.getTitle());

        String window2Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window",window2Text);

        Thread.sleep(5000);
        // When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(window1Handle);// switches window 1

        // Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet",driver.getTitle());

        Thread.sleep(5000);

        // Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);

        // Switch back to window 1
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);

        // Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);

        // Switch back to window 1
        driver.switchTo().window(window1Handle);
    }
}
