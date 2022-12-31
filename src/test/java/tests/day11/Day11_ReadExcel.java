package tests.day11;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day11_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // workbook>worksheet>row>cell
        // Store the path of the  file in a string
        String path = "./src/test/java/resources/Capitals.xlsx";

        // Open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        // Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");
        // workbook.getSheetAt(0);
        
        // Go to first row
        Row row1 = sheet1.getRow(0);// index starts from 0. Going to the first row
        
        // Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);// index starts at 0. Reading the first cell data that is on the first row
        System.out.println("cell1 = " + cell1);

        // We can convert the cell data to String
        String cell1Data = cell1.toString();
        System.out.println("cell1Data = " + cell1Data);
        
        // Go to second cell on that first row and print
        Cell r1c2 = row1.getCell(1);
        System.out.println("r1c2 = " + r1c2.toString());

        // Go to 2nd row first cell and assert if the data equal to USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("USA",r2c1);// Method Chain

        // Go to 3rd row 2nd cell-chain the row and cell
        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println("r3c2 = " + r3c2);

        // Find the number of row
        int numberOfRow = sheet1.getLastRowNum() + 1;// index starts at 0, so add 1 to find total number of rows
        System.out.println("numberOfRow = " + numberOfRow);

        // Find the number of used row
        int numberOfData = sheet1.getPhysicalNumberOfRows();// index starts at 1. Returns the number of row that has a data
        System.out.println("numberOfData = " + numberOfData);

        // Print country, capitol key value pairs as map object
        // Create a Map that will store the country, capital pairs
        Map<String,String> countryCapitals = new HashMap<>();
        for (int rowNum=1; rowNum<numberOfRow; rowNum++){// row index starts at 1, ends at 11
            String country = sheet1.getRow(rowNum).getCell(0).toString();
            String capital = sheet1.getRow(rowNum).getCell(1).toString();
            countryCapitals.put(country,capital);
        }
        System.out.println(countryCapitals);
    }
}
