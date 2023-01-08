package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Toggle extends TestBase {
    // When user goes to https://jqueryui.com/toggle/
    // Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    // Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    // Then click on Run Effect button
    // Then print the text and verify it is empty.
    //   Eg: System.out.println(element); -> NO TEXT
    // Then click on Run Effect button one more time
    // Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    //   Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    // You can use hard wait if needed.

    @Test
    public void test(){

        // When user goes to https://jqueryui.com/toggle/
        driver.get("https://jqueryui.com/toggle/");

        // Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus,
        // adipiscing ut, luctus sed, hendrerit vitae, mi.
        // Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
        // Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
        driver.switchTo().frame(0);
        String text = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("text = " + text);

        // Then click on Run Effect button
        driver.findElement(By.xpath("//button[@id='button']")).click();

        waitFor(2);

        // Then print the text and verify it is empty.
        // Eg: System.out.println(element); -> NO TEXT
        String emptyText = driver.findElement(By.className("toggler")).getText();
        System.out.println("emptyText = " + emptyText);
        assertTrue(emptyText.isEmpty());

        // Then click on Run Effect button one more time
        driver.findElement(By.xpath("//button[@id='button']")).click();

        waitFor(2);

        // Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
        // Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
        // Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
        // Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
        String text2 = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("text2 = " + text2);

        // You can use hard wait if needed.
    }
}
