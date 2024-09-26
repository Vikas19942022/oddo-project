package ReadData;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtils {

    @DataProvider(name = "Read")
    public Object[][] readFromExcelLoginData() throws IOException {
        FileInputStream ip = null;
        XSSFWorkbook workbook = null;
        Object[][] data = null;

        try {
            // Initialize the FileInputStream with the Excel file path
            ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\ReadData\\Ninja.xlsx");
            
            // Create a Workbook instance for the Excel file
            workbook = new XSSFWorkbook(ip);
            
            // Get the specified sheet from the workbook
            XSSFSheet sheet = workbook.getSheet("Read");
            
            // Get the number of rows and columns
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();
            
            // Initialize the array with the dimensions of the data
            data = new Object[rowCount - 1][colCount]; // Skipping the header row
            
            // Loop through rows and columns to read data
            for (int i = 1; i < rowCount; i++) { // Starting from 1 to skip the header
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
            
        } finally {
            // Ensure resources are closed to prevent leaks
            if (workbook != null) {
                workbook.close();
            }
            if (ip != null) {
                ip.close();
            }
        }

        return data;
    }
}
