package tests.day08;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Day08_WindowHandle2_ extends TestBase {
    /*
     Open 3 new windows and verify their titles --
    Given
        Open "https://www.techproeducation.com" on window 1
    When
        Get the title of the page
    Then
        Verify that title contains "Techpro Education"
    When
        Open "https://www.amazon.com" on a NEW window 2
    And
        Get the title of the page
    Then
        Verify that title contains "Amazon"
    When
        Open "https://www.linkedin.com" on a NEW window 3
    And
        Get the title of the page
    Then
        Verify that title contains "LinkedIn"
    When
        Switch back to Techpro
    And
        Switch back to Amazon
    And
        Switch back to Linkedin
     */

    @Test
    public void newWindowTest() throws InterruptedException {
        // Open "https://www.techproeducation.com" on window 1
        driver.get("https://www.techproeducation.com");

        // Get the title of the page
        String techproTitle = driver.getTitle();

        // Verify that title contains "Techpro Education"
        assertTrue(techproTitle.contains("Techpro Education"));

        // Get the id of the page
        String techproWindowHandle = driver.getWindowHandle();

        // Open "https://www.amazon.com" on a NEW window 2
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");

        // Get the title of the page
        String amazonTitle = driver.getTitle();

        // Verify that title contains "Amazon"
        assertTrue(amazonTitle.contains("Amazon"));

        // Get the id of the page
        String amazonWindowHandle = driver.getWindowHandle();

        // Open "https://www.linkedin.com" on a NEW window 3
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");

        // Get the title of the page
        String linkedinTitle = driver.getTitle();

        // Verify that title contains "LinkedIn"
        assertTrue(linkedinTitle.contains("LinkedIn"));

        // Get the id of the page
        String linkedinWindowHandle = driver.getWindowHandle();

        // Switch back to Techpro
        Thread.sleep(2000);
        driver.switchTo().window(techproWindowHandle);

        // Switch back to Amazon
        Thread.sleep(2000);
        driver.switchTo().window(amazonWindowHandle);

        // Switch back to Linkedin
        Thread.sleep(2000);
        driver.switchTo().window(linkedinWindowHandle);
    }

    /*
    /*
   -- Open 3 new tabs and verify their titles --
    Given
        Open "https://www.techproeducation.com" on Tab 1
    When
        Get the title of the page
    Then
        Verify that title contains "Techpro Education"
    When
        Open "https://www.amazon.com" on a NEW Tab 2
    And
        Get the title of the page
    Then
        Verify that title contains "Amazon"
    When
        Open "https://www.linkedin.com" on a NEW Tab 3
    And
        Get the title of the page
    Then
        Verify that title contains "LinkedIn"
    When
        Switch back to Techpro
    And
        Switch back to Amazon
    And
        Switch back to Linkedin
*/

    @Test
    public void newTabTest() throws InterruptedException {
        // Open "https://www.techproeducation.com" on Tab 1
        driver.get("https://www.techproeducation.com");

        // Get the title of the page
        String techproTitle = driver.getTitle();

        // Verify that title contains "Techpro Education"
        assertTrue(techproTitle.contains("Techpro Education"));

        // Get the id of the page
        String techproWindowHandle = driver.getWindowHandle();

        // Open "https://www.amazon.com" on a NEW Tab 2
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        // Get the title of the page
        String amazonTitle = driver.getTitle();

        // Verify that title contains "Amazon"
        assertTrue(amazonTitle.contains("Amazon"));

        // Get the id of the page
        String amazonWindowHandle = driver.getWindowHandle();

        // Open "https://www.linkedin.com" on a NEW Tab 3
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");

        // Get the title of the page
        String linkedinTitle = driver.getTitle();

        // Verify that title contains "LinkedIn"
        assertTrue(linkedinTitle.contains("LinkedIn"));

        // Get the id of the page
        String linkedinWindowHandle = driver.getWindowHandle();

        // Switch back to Techpro
        Thread.sleep(2000);
        driver.switchTo().window(techproWindowHandle);

        // Switch back to Amazon
        Thread.sleep(2000);
        driver.switchTo().window(amazonWindowHandle);

        // Switch back to Linkedin
        Thread.sleep(2000);
        driver.switchTo().window(linkedinWindowHandle);
    }
}
