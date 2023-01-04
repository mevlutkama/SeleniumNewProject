package tests.day14;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {

    @Test
    public void timeOutTest(){
        driver.get("https://techproeducation.com/");

        // Trying to locate the element using Explicit wait
        // We get timeout exception because explicit wait could not handle the issue.
        waitForVisibility(By.id("wrong-id"),15);// org.openqa.selenium.TimeoutException
    }
}
