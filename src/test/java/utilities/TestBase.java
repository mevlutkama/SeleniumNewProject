package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// 15 seconds wait in case needed
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    // Auto Complete Reusable Method
    // This code is used for selecting and verifying our app auto complete search functionality
    // Note: This reusable method designed for our current project. This may not work for new projects, but can be modified and used for that new project
    // Note: You will see this kind of reusable method that is specific to your own project
    // The point of reusable method is: Write once use multiple times to save time and short test class.
    public static void searchAndSelectFromList(String keyword, String textFromList) throws InterruptedException {
        Thread.sleep(2000);// putting wait to see steps slower
        // Sending a keyword dynamically using parameter 1
        driver.findElement(By.id("myCountry")).sendKeys(keyword);

        Thread.sleep(2000);
        // Selecting an option from the list dynamically using parameter 2
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='" + textFromList + "']")).click();

        Thread.sleep(2000);
        // Nothing special. Just clicking on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();// click on submit button

        Thread.sleep(2000);
        // Verifying if result contains the option that I selected dynamically using parameter 2.
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains(textFromList));
    }

    // Take screenshot of entire page with this reusable method
    public void takeScreenshotOfPage() throws IOException {
        // 1.Step: Take screenshot using getScreenshotAs() method and takeScreenshot API coming from selenium
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // 2.Step: Save the screenshot in a path and save with dynamic name
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// getting the current local date
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png"; // Where we save the image

        FileUtils.copyFile(image,new File(path));
    }
}


