package tests.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

public class Day10_ScreenshotsOfEntirePage extends TestBase {

    @Test
    public void takeScreenShotTest() throws IOException, InterruptedException {
        // Given user search for 'uni'
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        // Take a screenshot. Create a reusable method and call that method
        takeScreenshotOfPage();

        Thread.sleep(3000);
        // Complete as homework
        driver.findElement(By.id("myCountry")).sendKeys("uni");

        Thread.sleep(3000);
        // Take a screenshot. Create a reusable method and call that method
        takeScreenshotOfPage();

        Thread.sleep(3000);
        // And select United Kingdom
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();

        Thread.sleep(3000);
        // Take screenshot
        takeScreenshotOfPage();

        Thread.sleep(3000);
        // And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

        Thread.sleep(3000);
        // Take screenshot
        takeScreenshotOfPage();

        Thread.sleep(3000);
        // Then verify the result contains United Kingdom
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));

        Thread.sleep(3000);
        // Take screenshot
        takeScreenshotOfPage();
    }
}
