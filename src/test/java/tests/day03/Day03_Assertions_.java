package tests.day03;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Day03_Assertions_ {

    @Test
    public void assertions(){
        /*
            What is assertion in testing?
            Assertion is done to check if the expected data is equal to actual data.
            - expected == actual ==> PASS
            - expected != actual ==> FAIL

            --------------------
            assertEquals("expected", "actual") --> If expected is equal to actual, it will PASS otherwise it will FAIL.
            assertTrue(true) ==> PASS
            assertTrue(false) ==> FAIL
            assertFalse(false) ==> PASS
            assertFalse(true) ==> FAIL

         */

        if ("John".contains("X")){
            System.out.println("Test Passed");
        }else {
            System.out.println("TEST FAILED");
        }

        Assert.assertEquals(2,2);
        // Assert.assertEquals("Values did not match", 1, 2); // FAIL

        assertTrue(true);// PASS
        // assertTrue(false);// FAIL
        int a = 3;
        int b = 5;

        //assertTrue(a == b); // FAIL
        assertFalse(a == b); // PASS
        assertFalse(a > b);// PASS

        String name = "John";
        assertTrue(name.contains("J"));
        assertFalse(name.contains("A"));

        /*
            What is the difference between Assertion and Verification?
            Assertion stops the execution in failure. Verification continues even after failure.
            JUnit assertions are hard assertions. If statement is verification.

            Hard Assertion: If the execution stops in failure it is called Hard Assertion
            Verification: If the execution continues in failure it is called Verification.

         */


    }
}
