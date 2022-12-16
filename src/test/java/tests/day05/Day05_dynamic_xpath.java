package tests.day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_dynamic_xpath {
    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void dynamicXpath(){

        // There are different xpath to locate a text element on a page
        // 1.xpath = //*[.='text of the element']
        // Verify if "Username : Admin" is text is displayed on the page
        // [.='Username : Admin'] return the element whose text = Username : Admin
        WebElement userNameText = driver.findElement(By.xpath("//*[.='Username : Admin']"));
        Assert.assertTrue(userNameText.isDisplayed());

        // Verify if "Password : admin123" is text is displayed on the page
        WebElement passwordText = driver.findElement(By.xpath("//*[.='Password : admin123']"));// accepts full text
        Assert.assertTrue(passwordText.isDisplayed());

        // Verify if "Username : Admin" is text is displayed on the page
        // 2.xpath = //[(text()='Text of the element')]
        WebElement userNameText1 = driver.findElement(By.xpath("//*[(text()='Username : Admin')]"));// accepts full text
        Assert.assertTrue(userNameText1.isDisplayed());

        // Verify if "Password" is text is displayed on the page
        // 3.xpath = //*[contains(text(), 'partial or full text of the element'
        WebElement passwordText1 = driver.findElement(By.xpath("//*[contains(text(),'Passw')]"));// accepts partial text
        Assert.assertTrue(passwordText1.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
