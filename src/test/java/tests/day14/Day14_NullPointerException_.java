package tests.day14;

import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class Day14_NullPointerException_ {

    WebDriver driver;// null
    Integer number;

    @Test
    public void nullPointerExceptionTest(){

        driver.get("https://techproeducation.com/");// java.lang.NullPointerException
    }

    @Test
    public void nullPointerExceptionTest2(){
        // java.lang.NullPointerException
        System.out.println(number + 1);// number is not assigned
    }
}
