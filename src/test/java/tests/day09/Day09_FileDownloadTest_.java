package tests.day09;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileDownloadTest_ extends TestBase {
    /*
        Given
            Go to "https://testcenter.techproeducation.com/index.php?page=file-download"
        When
            Download b10 all test cases, code.docx
        Then
            Verify if the file downloaded successfully
     */

    @Test
    public void downloadTest(){
        // Go to "https://testcenter.techproeducation.com/index.php?page=file-download"
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        // Download b10 all test cases, code.docx file
        driver.findElement(By.partialLinkText("code.docx")).click();

        // Verify if the file downloaded successfully
        String userHome = System.getProperty("user.home");

        boolean isDownloaded = Files.exists(Paths.get(userHome + "/Downloads/b10 all test cases, code.docx"));
        assertTrue(isDownloaded);
    }
}
