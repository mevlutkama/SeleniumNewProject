package automation_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {

        // 1.Set up Chrome Driver
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

        // 2.Create Chrome Driver
        WebDriver driver = new ChromeDriver();

        // 3.Now that we created webdriver, we can automate web application
        driver.get("https://www.techproeducation.com");

        driver.quit();
    }
}
