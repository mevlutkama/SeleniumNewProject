package tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    public static void main(String[] args) {

        // System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        // Test if amazon contains “Registry” on the homepage
        String pageSource = driver.getPageSource();
        //System.out.println("pageSource = " + pageSource);

        String expectedWord = "Registry";

        if (pageSource.contains(expectedWord)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("PAGE SOURCE: " + pageSource);
            System.out.println("EXPECTED WORD: " + expectedWord);
        }

        driver.quit();
    }
}
