package tests.day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day10_FileUpload extends TestBase {

    /*
        When user goes to https://the-internet.herokuapp.com/upload
        When user selects an image from the desktop
        And click on the upload button
        Then verify the File Uploaded!  Message displayed
     */

    @Test
    public void fileUploadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");
        // 1.Step: Locate choose file and click choose file
        // <input type="file">
        WebElement chooseAFileButton = driver.findElement(By.id("file-upload"));

        Thread.sleep(2000);

        // 2.Step: Select a file from your computer
        String userHOME = System.getProperty("user.home");
        String pathOfFile = userHOME + "\\Desktop\\logo.jpeg";

        // Sending the path of the file that I want to upload
        // We can use sendkeys cause the input type file combination
        chooseAFileButton.sendKeys(pathOfFile);

        // 3.Step: Then locate and click upload
        driver.findElement(By.id("file-submit")).click();

        // 4.Step: Asserting
        boolean isEqual = driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
        Assert.assertTrue(isEqual);
    }
    /*
        How do you upload a file with selenium?
        - First selenium has limitation automation of files. But file upload can be done with selenium.
        We locate the choose file button and use sendkeys function to send the path of the file.
        Then we click upload button to upload the file.
        Path of the file should be dynamic - use System.getProperty("user.home");

        LIMITATION:
        Selenium has limitation automation desktop apps
        For example, we can not find path of files, or verify if file exists on out machines with selenium
        Instead we use java file libraries
     */
}
