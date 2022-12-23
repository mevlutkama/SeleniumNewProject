package firstclass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterUserTest extends TestBase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    */

    @Test
    public void registerUserTest(){
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // Verify that home page is visible successfully
        boolean isDisplayed1 = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
        assertTrue(isDisplayed1);

        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // Verify 'New User Signup!' is visible
        boolean isDisplayed2 = driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
        assertTrue(isDisplayed2);

        // Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("marcel poitierqrty");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("marcelqrty@hotmail.com");

        // Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String text = driver.findElement(By.xpath("(//h2)[1]")).getText();
        System.out.println("text = " + text);
        assertEquals("ENTER ACCOUNT INFORMATION",text);

        // Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("12345");

        WebElement dropdown1 = driver.findElement(By.id("days"));
        Select select1 = new Select(dropdown1);
        select1.selectByIndex(10);

        WebElement dropdown2 = driver.findElement(By.id("months"));
        Select select2 = new Select(dropdown2);
        select2.selectByIndex(5);

        WebElement dropdown3 = driver.findElement(By.id("years"));
        Select select3 = new Select(dropdown3);
        select3.selectByIndex(15);

        // Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        // Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("marcel");
        driver.findElement(By.id("last_name")).sendKeys("poitier");
        driver.findElement(By.id("company")).sendKeys("Techpro");
        driver.findElement(By.id("address1")).sendKeys("ankara");
        driver.findElement(By.id("address2")).sendKeys("guzel ankara");

        WebElement dropdown4 = driver.findElement(By.id("country"));
        Select select4 = new Select(dropdown4);
        select4.selectByValue("United States");

        driver.findElement(By.id("state")).sendKeys("Arizona");
        driver.findElement(By.id("city")).sendKeys("texas");
        driver.findElement(By.id("zipcode")).sendKeys("58000");
        driver.findElement(By.id("mobile_number")).sendKeys("123456789");

        // Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // Verify that 'ACCOUNT CREATED!' is visible
        String text2 = driver.findElement(By.xpath("(//h2)[1]")).getText();
        assertEquals("ACCOUNT CREATED!",text2);

        // Click 'Continue' button
        driver.findElement(By.linkText("Continue")).click();

        // Verify that 'Logged in as username' is visible
        boolean isDisplayed4 = driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed();
        assertTrue(isDisplayed4);

        // Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String text3 = driver.findElement(By.xpath("(//h2)[1]")).getText();
        assertEquals("ACCOUNT DELETED!",text3);
    }
}
