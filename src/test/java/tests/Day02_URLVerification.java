package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerification {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        // Verify if homepage url is "https://techproeducation.com
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://techproeducation.com/";

        if (actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("ACTUAL URL: " + actualURL);
            System.out.println("BUT EXPECTED URL: " + expectedURL);
        }

        driver.quit();

        /*
        What is your approach for automation?
        - I read the acceptance criterias carefully.
        - I then create my test cases
        - Then I do my manual testing first
        - If all good, then I start complete my automation script
        - If I find a bug/defect, then I talk to dev. Dev fixes the issue, then I retest. If all is good then start my automation script.
        - When the automation is complete, I prepare the report for the user story. In fact, My automation script generates html reports for us
          I upload those reports to the JIRA.
        - For my manual test cases, I manually take screenshots and prepare reports and attach them to the JIRA.

        What do you do when your test case pass?
        - Prepare report and upload to JIRA

        What do you do when your test case fail?
        - Retest to make sure from the failure. It can be data issue, typo, documentation issue or is can be a real bug.
        - If that is a bug, then talk to the dev and let them fix the bug.
        - After the fix, we retest. When test cases passes we upload to JIRA

        What do you do when you find a bug?
        - Retest to make sure from the failure. It can be data issue, typo, documentation issue or is can be a real bug.
        - If that is a bug, then talk to the dev and let them fix the bug.
        - After the fix, we retest. When test cases passes we upload to JIRA
         */


    }
}
