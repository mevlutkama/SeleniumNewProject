package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AppleScript extends TestBase {
    // When user goes to https://jqueryui.com/autocomplete/
    // And type Apple
    // Then select Applescript

    @Test
    public void test(){
        // When user goes to https://jqueryui.com/autocomplete/
        driver.get("https://jqueryui.com/autocomplete/");

        // And type Apple
        driver.switchTo().frame(0);
        WebElement tags =  driver.findElement(By.id("tags"));
        tags.sendKeys("Apple");
        waitFor(2);
        WebElement appleScript = driver.findElement(By.xpath("//div[text()='AppleScript']"));
        clickByJS(appleScript);
    }
}
