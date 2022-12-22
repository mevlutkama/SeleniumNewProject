package tests.day09;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileExistTest_ {
    /*
    Given
        Create a file on desktop
    When
        Copy the path of file
    Then
        Assert if the file exists
    */

    // "C:\Users\SAMSUNG\Desktop\File.txt"
    @Test
    public void isExistTest(){
        
        String userDir = System.getProperty("user.dir");// Gives the path of the current project folder
        System.out.println("userDir = " + userDir);
        
        String userHome = System.getProperty("user.home");// Gives the user folder
        System.out.println("userHome = " + userHome);
        
        // Assert if the file exists
        boolean isExist = Files.exists(Paths.get(userHome + "\\Desktop\\File.txt"));// Writing the path dynamically so it will work on other computers.
        assertTrue(isExist);
    }
}
