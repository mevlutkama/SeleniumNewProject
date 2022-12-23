package practices2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q09 extends TestBase {
        // Go to URL : https://demo.automationtesting.in/Static.html
        // Drag and drop elements.

    @Test
    public void test09() throws InterruptedException {

        // Go to URL : https://demo.automationtesting.in/Static.html
        driver.get("https://demo.automationtesting.in/Static.html");

        // Drag and drop elements.
        // Locate sources:
        WebElement angular = driver.findElement(By.id("angular"));
        WebElement mongo = driver.findElement(By.id("mongo"));
        WebElement node = driver.findElement(By.id("node"));

        // Locate target
        WebElement droparea = driver.findElement(By.id("droparea"));

        // Create actions object
        Actions actions = new Actions(driver);
        actions.dragAndDrop(angular, droparea).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(mongo,droparea).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(node, droparea).perform();
    }
}
