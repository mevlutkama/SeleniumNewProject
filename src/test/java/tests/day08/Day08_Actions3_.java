package tests.day08;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions3_ extends TestBase {
    /*
    Given
        Go to "https://www.techproeducation.com"
    When
        Scroll down with "PAGE_DOWN" key 3 times
    And
        Scroll down with "ARROW_DOWN" key
    And
        Scroll up with "PAGE_UP" key
    And
        Scroll up with "ARROW_UP" key
     */

    @Test
    public void pageUpDownTest() throws InterruptedException {

        // Go to "https://www.techproeducation.com"
        driver.get("https://www.techproeducation.com");

        // Scroll down with "PAGE_DOWN" key 3 times
        Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Thread.sleep(2000);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Thread.sleep(2000);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();

        // We can also use method chain
        // build() method is recommended to use in method chainto make sure the connection between methods is strong
        // perform() method is must to use execute the action.
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

        // Scroll down with "ARROW_DOWN" key ==> ARROW_DOWN scrolls down less than PAGE_DOWN
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        // Scroll up with "PAGE_UP" key
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();

        // Scroll up with "ARROW_UP" key ==> ARROW_UP scrolls up less than PAGE_UP
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();
    }
}
