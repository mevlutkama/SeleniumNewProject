package automation_exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class TechListTest extends TestBase {
    /*
    Open this link - https://www.techlistic.com/p/selenium-practice-form.html
    Enter first and last name (textbox).
    Select gender (radio button).
    Select years of experience (radio button).
    Enter date.
    Select Profession (Checkbox).
    Select Automation tools you are familiar with (multiple checkboxes).
    Select Continent (Select box).
    Select multiple commands from a multi select box.
    If you can handle Upload image then try it or leave this step.
    Click on Download file link and handle the download file pop-up (leave it if you are beginner).
    Click on Submit button.
    Try your own logic and automate it without any help. If you still find it difficult to automate then follow reference links.
     */

    @Test
    public void techListTest() throws InterruptedException {
        // Open this link - https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        // Enter first and last name (textbox).
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Marcel");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Poitier");

        // Select gender (radio button).
        driver.findElement(By.id("sex-0")).click();

        // Select years of experience (radio button).
        driver.findElement(By.id("exp-0")).click();

        // Enter date.
        driver.findElement(By.id("datepicker")).sendKeys("25/12/2022");

        // Select Profession (Checkbox).
        WebElement professionCheckbox = driver.findElement(By.xpath("//input[@value='Automation Tester']"));
        professionCheckbox.click();

        // Select Automation tools you are familiar with (multiple checkboxes).
        driver.findElement(By.id("tool-1")).click();
        driver.findElement(By.id("tool-2")).click();

        // Select Continent (Select box).
        WebElement continents = driver.findElement(By.id("continents"));
        Select select = new Select(continents);
        select.selectByIndex(3);

        // Select multiple commands from a multi select box.
        WebElement multipleOption = driver.findElement(By.xpath("//option[.='Browser Commands']"));
        multipleOption.click();

        // If you can handle Upload image then try it or leave this step.
        WebElement chooseAFileButton = driver.findElement(By.id("photo"));
        Thread.sleep(2000);

        String userHome = System.getProperty("user.home");
        String pathOfFile = userHome + "\\Desktop\\logo.jpeg";
        chooseAFileButton.sendKeys(pathOfFile);

        // Click on Download file link and handle the download file pop-up (leave it if you are beginner).

    }
}
