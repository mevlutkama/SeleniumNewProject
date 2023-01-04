package tests.day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day14_StaleElementException extends TestBase {

    @Test
    public void staleException1() {
        driver.get("https://techproeducation.com/");

        // location lmsLogin
        WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));

        // clicking lmsLogin
        lmsLogin.click();
        waitFor(5);

        // going back to home page
        driver.navigate().back();
        waitFor(5);

        // clicking lmsLogin
        // Failed cause lmsLogin is no longer fresh. It is old. It is Stale
        lmsLogin.click();

        // Solition: Relocate the element
        // driver.findElement(By.linkText("LMS LOGIN")).click();
    }
}