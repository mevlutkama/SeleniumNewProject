package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class DatePicker extends TestBase {

    // When user goes to https://jqueryui.com/datepicker/
    // And select the next date of the current date
    // EG if today is August 30, 2022 -> select August 31, 2022

    @Test
    public void test(){

        // When user goes to https://jqueryui.com/datepicker/
        driver.get("https://jqueryui.com/datepicker/");

        // And select the next date of the current date
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).click();
    }
}
