package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.function.Function;

public abstract class TestBase {
    protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// 10 seconds wait in case needed
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()  {
        waitFor(3);
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
    public void takeScreenshotOfPage() {
        // 1.Step: Take screenshot using getScreenshotAs() method and takeScreenshot API coming from selenium
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // 2.Step: Creating a path and dynamic name for the image
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// getting the current local date

        // Path is where we save the screenshot. Project/Folder/Folder/Name of Image  . png
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png"; // Where we save the image

        // 3.Step: Saving the image in the path
        try {
            FileUtils.copyFile(image,new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Take screenshot of specific element
    public void takeScreenshotOfTheElement(WebElement element) throws IOException {

        // 1.Step: Take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);

        // 2.Step: Create a dynamic path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// getting the current local date

        // Path is where we save the screenshot. Project/Folder/Folder/Name of Image  . png
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png"; // Where we save the image

        // 3.Step: Saving the image in the path
        FileUtils.copyFile(image,new File(path));
    }

    /*
        Javascript Executor
        @param webelement
        Accepts a webelement and scrolls into that element
        We may need to scroll for capturing the screenshots properly
        We may need to scroll to specific elements with js executor because some elements may not load properly
        unless we scroll to that elements
     */
    public void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /*
        scroll the page all the down
     */
    public void scrollAllDownByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /*
        scroll the page all the way up
     */
    public void scrollAllUpByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    /*
        click on an element
        @param WebElement
        Normally we use element.click() method in selenium
        When there is an issue with click()-hidden, different UI,...
        Then we can use javascript click that works better
     */
    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    /*
        @param: WebElement, String
        Types the string in the WebElement
        element.sendKeys("text") to type in an input
        Alternatively we can use js executor to type in an input
        arguments[0].setAttribute('value','admin123'); -> same as element.sendKeys("admin123")

        Interview Question: What are the selenium methods that you use to type in an input?
        - sendKeys()
        - with javascript executor we can use change the value of the input
     */
    public void setValueByJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
    }

    /*
        param: Id of the element
     */
    public void getValueByJS(String idOfElement){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);
        // How you get the value of an input box?
        // We can js executor.
        // How?
        // I can get the element using js executor, and get the value of the element.
        // For example, I can get the element by id, and use value attribute to get the value of in an input
        // I have to do this, cause getText in this case does not return the text in an input
    }

    // Changes the changeBackgroundColorByJS of an element.
    // Params: WebElement element, String color. NOT COMMON
    public void changeBackgroundColorByJS(WebElement element, String color){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
    }

    // NOT COMMON
    public void addBorderWithJS(WebElement element, String borderStyle){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);
    }

    // Hard Wait:
    // @param: second
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    DYNAMIC SELENIUM WAITS:
    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    // This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //======Fluent Wait====
    // params: xpath of the element, max timeout in seconds, polling in seconds
    public static WebElement fluentWait(String xpath, int withtimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withtimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }
}


