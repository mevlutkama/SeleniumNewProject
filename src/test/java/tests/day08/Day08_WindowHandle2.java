package tests.day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Day08_WindowHandle2 extends TestBase {

    @Test
    public void newWindowTest() throws InterruptedException {
        // open techproeducation on window 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();

        Thread.sleep(3000);
        // open amazon on a new window 2
        driver.switchTo().newWindow(WindowType.WINDOW);// create a new window and switches to that window automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();// getting window 2 id

        Thread.sleep(3000);
        // open linkedin on a new window 3
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();

        Thread.sleep(3000);
        // Switch back to Techpro
        driver.switchTo().window(techProHandle);
        System.out.println("Techpro: " + driver.getCurrentUrl());

        Thread.sleep(3000);
        // Switch back to Amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon: " + driver.getCurrentUrl());

        Thread.sleep(3000);
        // Switch back to Linkedin
        driver.switchTo().window(linkedinHandle);
        System.out.println("Linkedin: " + driver.getCurrentUrl());
    }

    @Test
    public void newTabTest() throws InterruptedException {
        // WINDOW ==> TAB

        // open techproeducation on window 1
        driver.get("https://www.techproeducation.com");
        String techProTitle = driver.getTitle();
        Assert.assertTrue(techProTitle.contains("Techpro Education"));
        String techProHandle = driver.getWindowHandle();

        Thread.sleep(3000);
        // open amazon on a new window 2-TAB
        driver.switchTo().newWindow(WindowType.TAB);// create a new TAB 2 and switches to that window automatically
        driver.get("https://www.amazon.com");
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        String amazonHandle = driver.getWindowHandle();// getting TAB 2 id

        Thread.sleep(3000);
        // open linkedin on a new window 3-TAB
        driver.switchTo().newWindow(WindowType.TAB);// create a new TAB 3 and switches to that window automatically
        driver.get("https://www.linkedin.com");
        String linkedinTitle = driver.getTitle();
        Assert.assertTrue(linkedinTitle.contains("LinkedIn"));
        String linkedinHandle = driver.getWindowHandle();// getting TAB 3 id

        Thread.sleep(3000);
        // Switch back to Techpro
        driver.switchTo().window(techProHandle);
        System.out.println("Techpro: " + driver.getCurrentUrl());

        Thread.sleep(3000);
        // Switch back to Amazon
        driver.switchTo().window(amazonHandle);
        System.out.println("Amazon: " + driver.getCurrentUrl());

        Thread.sleep(3000);
        // Switch back to Linkedin
        driver.switchTo().window(linkedinHandle);
        System.out.println("Linkedin: " + driver.getCurrentUrl());
    }
}
