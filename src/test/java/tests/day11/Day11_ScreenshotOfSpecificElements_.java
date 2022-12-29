package tests.day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Day11_ScreenshotOfSpecificElements_ extends TestBase {
    /*
    Given
        Go to https://www.techproeducation.com
    Then
        Assert the logo is displayed
    And
        Take screenshot  of logo
    And
        Take screenshot of social media icons
     */

    @Test
    public void screenshotTest() throws IOException {
        // Go to https://www.techproeducation.com
        driver.get("https://www.techproeducation.com");

        // Assert the logo is displayed
        WebElement logo = driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        assertTrue(logo.isDisplayed());

        // Take screenshot  of logo
        takeScreenshotOfTheElement(logo);

        // Take screenshot of social media icons
        WebElement icon = driver.findElement(By.xpath("//div[@data-id='19d2990']"));
        takeScreenshotOfTheElement(icon);

    }
}
