package tests.day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Day09_Cookies extends TestBase {
    /*
        Cookies are temporary files that is generated by the browsers.
        It's a way for a website to remember you, your preferences, and your habits online.
    */

    @Test
    public void cookieTest() throws InterruptedException {

        // Go to amazon and automate the tasks
        driver.get("https://www.amazon.com");

        // 1.Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);// Mine is 8

        // 2.Print all the cookies
        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie ==>>> " + eachCookie);
            System.out.println("Cookie Value ==>>> " + eachCookie.getValue());
            System.out.println("Cookie Name ===>>> " + eachCookie.getName());
        }

        // 3.Get the cookies by their name
        System.out.println("Cookie Named: " + driver.manage().getCookieNamed("i18n-prefs"));// entering cookie name and getting the value

        // 4.Add new cookie
        Cookie cookie = new Cookie("my-favourite-cookie", "apple-pie");

        driver.manage().addCookie(cookie);
        Thread.sleep(2000);
        Set<Cookie> newCookies = driver.manage().getCookies();
        System.out.println("New Number of Cookies ===>>> " + newCookies.size());// 1 more than original number of cookie

        // 5.Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");
        Thread.sleep(2000);
        int lastNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("lastNumberOfCookies ===>>> " + lastNumberOfCookies);

        // 6.Delete all of the cookies
        driver.manage().deleteAllCookies();
        Thread.sleep(2000);
        int finalNumberOfCookies = driver.manage().getCookies().size();
        System.out.println("finalNumberOfCookies ===>>> " + finalNumberOfCookies);
    }
}