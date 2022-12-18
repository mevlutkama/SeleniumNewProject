package homeworks;

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

public class GoogleTest {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testTitle(){
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        if (title.equals("Google")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }

    @Test
    public void testImage(){
        driver.get("https://www.google.com/");
        WebElement image = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        if (image.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }

    @Test
    public void testLink(){
        driver.get("https://www.google.com/");
        WebElement link = driver.findElement(By.className("gb_j"));
        if (link.isDisplayed()){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
