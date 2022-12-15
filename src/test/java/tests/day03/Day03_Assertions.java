package tests.day03;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {
    @Test
    public void assertions() {
        /*
            What is assertion in testing?
            - expected == actual ==> pass
            - expected != actual ==> fail
            ------------------
            assertEquals("expected","actual");
            assertTrue(true); ==> pass
            assertTrue(false); ==> fail
            assertFalse(false); ==> pass
            assertFalse(true); ==> fail
        */

        Assert.assertEquals(5, 5);

        if ("java".contains("apple")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        Assert.assertEquals("java", "java");
        Assert.assertEquals("java".contains("j"), true);
        Assert.assertTrue("java".contains("j"));
        Assert.assertFalse("Java".contains("j"));

        // Test Execution stops if one the assertion fails. This is called HARD ASSERTION
        // Test Execution continues even if test verification fails. Verification means like if statement
        // What is difference between Assertion and Verification
        // Assertion stops after assertion fails. Verification continues even after verification fails.
        // Junit assertions are hard assertion. If statement is verification
        // NOTE: TestNG has soft assertion as well. We will learn it in TestNG.
    }
}