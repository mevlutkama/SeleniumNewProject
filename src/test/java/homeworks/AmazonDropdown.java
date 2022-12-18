package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

// Create A Class: AmazonDropdown
public class AmazonDropdown {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/tr");
    }

    // Create A Method dropdownTest
    @Test
    public void dropdownTest(){
        // Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);

        // Print the first selected option and assert if it equals “All Departments”.
        // If it fails, then comment that code out and continue rest of the test case.
        String firstSelectedOption = select.getFirstSelectedOption().getText();
        System.out.println("firstSelectedOption = " + firstSelectedOption);

        if (firstSelectedOption.equals("All Departments")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        // Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        // (after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        select.selectByIndex(3);
        String actualResult = select.getFirstSelectedOption().getText();
        String expectedResult = "Amazon Devices";
        // assertEquals("TEST FAILED",expectedResult,actualResult);

        // Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions){
            System.out.println(eachOption.getText());
        }

        // Print the the total number of options in the dropdown
        int totalNumOfOptions = select.getOptions().size();
        System.out.println("numOfOptions = " + totalNumOfOptions);

        // Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        List<String> listOfOptions = new ArrayList<>();
        for (WebElement eachOption : allOptions){
            listOfOptions.add(eachOption.getText());
        }

        System.out.println("listOfOptions = " + listOfOptions);

        if (listOfOptions.contains("Appliances")){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }

        // BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> sortedList = listOfOptions.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedList = " + sortedList);
        assertEquals("Dropdown is not in Alphabetical Order",listOfOptions,sortedList);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
