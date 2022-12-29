package tests.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class Day11_ScreenshotOfSpecificElements extends TestBase {

    @Test
    public void screenshotTest() throws IOException {
        driver.get("https://www.techproeducation.com");
        WebElement techProEdLogo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));

        // Verifying the logo
        Assert.assertTrue(techProEdLogo.isDisplayed());

        // Getting the screenshot using reusable method
        takeScreenshotOfTheElement(techProEdLogo);

        // Taking screenshot of social media icons
        WebElement socials = driver.findElement(By.xpath("//div[@data-id='d7545f2']"));
        takeScreenshotOfTheElement(socials);
    }
}
