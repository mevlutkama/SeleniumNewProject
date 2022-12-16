package tests.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_xpath_css {
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
    public void loginTest(){
        // locating username and typing username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

        // locating password and typing password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        // locating login button and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void loginTestCss(){
        // locating username and typing username
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");

        // locating password and typing password
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");

        // locating login button and click
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    /*
        * How many locators are there?
        * --- 8 locators.
        * What are they?
        * --- id, name, className, linkText, tagName, partialLinkText, xpath, css
        * Which one do you prefer? Why?
        * --- First if there is an ID I use id, cause id is umique and faster
        * --- If there is no id then I use name if there is a unique name
        * --- I also sometimes create dynamic xpath. Because some elements do not have stable attributes like id and name.
        * --- And I can write xpath for any element.
        * --- I sometimes even use css selector instead of xpath. But I personally use xpath more than css
        * What is difference between xpath and css selector?
        * --- Absolute xpath we start from the parent and go child elements one by one
        * --- Absolute xpath use /
        * --- Absolute xpath may easily be broken when a new element is added on the page.
        * --- For this reason we should never use absolute xpath. In fact, my team don't let QA's use absolute xpath.
        * --- Relative xpath we don't start from parent and go child one by one. We go straight to the element
        * --- Relative xpath use //
        * --- Relative xpath is very reliable it doesn't easy brake, because absolute xpath doesn't dependent on other element
        * --- I use relative xpath in my framework when to locate the elements
        * What is difference between xpath and css selector?
        * --- First xpath and css are similar. Both are helpful and there are different ways to create xpath or css
        * --- Syntax is a little different.
        * --- in xpath we use // and @, but in css we don't
        * --- css is a little faster than xpath(way less than second). xpath does navigation in the html that takes a little bit time.
        * --- there are more ways to write xpath. For example, dynamic xpath has contains, starts-with, ends-with functions.
     */
}
