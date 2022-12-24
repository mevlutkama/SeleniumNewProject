package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

// Create a new class: AmazonSearch
public class AmazonSearch extends TestBase {
    /*
        TC01_As user I want to know how many item are there on amazon in the first page after I search “porcelain teapot”?
        TC02_Order the the tea pot prices, find the min, max, and average price to the nearest cent.
    */

    @Test
    public void amazonSearchTest(){
        // Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // TC01_As user I want to know how many item are there on amazon in the first page after I search “porcelain teapot”?
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot");
        driver.findElement(By.id("nav-search-submit-button")).click();
        List<WebElement> allItems = driver.findElements(By.xpath("//img[@class='s-image']"));
        int numOfAllItems = allItems.size();
        System.out.println("numOfAllItems = " + numOfAllItems);

        // TC02_Order the the tea pot prices, find the min, max, and average price to the nearest cent.
        driver.findElement(By.className("a-dropdown-prompt")).click();
        driver.findElement(By.id("s-result-sort-select_1")).click();

        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
        for (WebElement w : prices){
            System.out.print(w.getText() + " ");
        }

    }
}
