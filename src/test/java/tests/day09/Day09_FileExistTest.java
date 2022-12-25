package tests.day09;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExistTest {
    @Test
    public void isExistTest() {
        String userDIR = System.getProperty("user.dir");// ==> gives the path of the current folder
        System.out.println("userDIR = " + userDIR);// C:\Users\SAMSUNG\Desktop\SeleniumNewProject

        String userHOME = System.getProperty("user.home");// ==> gives you the user folder
        System.out.println("userHOME = " + userHOME);// C:\Users\SAMSUNG

        // Pick a file on your desktop
        // And verify if that file exist on your computer or not
        String pathOfFile = userHOME + "\\Desktop\\logo.jpeg";// Writing the path dynamically so this path can work on other laptops

        boolean isExist = Files.exists(Paths.get(pathOfFile));// returns TRUE if file exists. FALSE if file doesn't exist.
        Assert.assertTrue(isExist);// Passes if file exist, Fails if file doesn't exist
    }
}