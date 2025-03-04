package core;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    public static Object[][] getTableArray(String filePath, String sheetName, int startCol, int totalCol) {
        String[][] table = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int startRow = 1;
            int ci = 0, cj = 0;
            int totalRow = sheet.getLastRowNum();
            table = new String[totalRow][totalCol];

            for (int i = startRow; i <= totalRow; i++, ci++) {
                for (int j = startCol; j <= totalCol; j++, cj++) {
                    XSSFCell cell = sheet.getRow(i).getCell(j);
                    table[ci][cj] = cell.getStringCellValue();
                }
                cj = 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return table;
    }
}
