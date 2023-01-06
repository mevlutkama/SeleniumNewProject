package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class HW01 extends TestBase{

    // When user goes to https://jqueryui.com/accordion/
    // And user clicks on Section2 accordion
    // Verify the text contains “Sed non urna.”

    @Test
    public void test01(){

        // When user goes to https://jqueryui.com/accordion/
        driver.get("https://jqueryui.com/accordion/");

        // And user clicks on Section2 accordion
        driver.switchTo().frame(0);
        WebElement section2 = driver.findElement(By.xpath("//h3[@id='ui-id-3']"));
        clickByJS(section2);

        // Verify the text contains “Sed non urna.”
        String text = driver.findElement(By.xpath("//*[@id='ui-id-4']")).getText().toString();
        System.out.println("text = " + text);
        assertTrue(text.contains("Sed non urna"));
    }
}
