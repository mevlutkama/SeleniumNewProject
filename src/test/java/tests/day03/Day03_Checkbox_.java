package tests.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day03_Checkbox_ {

        // User goes to https://testcenter.techproeducation.com/index.php?page=checkboxes
        // Locationg checkbox 1 and checkbox2
        // Click on the checkbox 1 if it is NOT already selected
        // Click on the checkbox 2 if it is NOT already selected
        // Then verify that checkbox1 is checked.
    WebDriver driver;

    @Before
    public void setUp(){

        // User goes to https://testcenter.techproeducation.com/index.php?page=checkboxes
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
    }

    @Test
    public void checkBoxTest() throws InterruptedException {

        // Locationg checkbox 1 and checkbox2
        WebElement checkBox1 = driver.findElement(By.id("box1"));
        WebElement checkBox2 = driver.findElement(By.id("box2"));

        // Click on the checkbox 1 if it is NOT already selected
        Thread.sleep(2000);// This is going to wait 3 seconds in every scenario
        if (!checkBox1.isSelected()){// isSelected() method return true if it was selected before.
            checkBox1.click();
        }

        // Click on the checkbox 2 if it is NOT already selected
        Thread.sleep(2000);// Hard wait ==> Java wait
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }

        // Then verify that checkbox1 is checked.
        assertTrue(checkBox1.isSelected());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
