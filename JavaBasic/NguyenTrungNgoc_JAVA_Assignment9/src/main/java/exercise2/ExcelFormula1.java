package exercise2;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelFormula1 {
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student Data");
        CellStyle blueStyle = workbook.createCellStyle();
        blueStyle.setFillBackgroundColor(IndexedColors.BLUE_GREY.index);

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Students");
        header.createCell(1).setCellValue("Paper1");
        header.createCell(2).setCellValue("Paper2");
        header.createCell(3).setCellValue("Paper3");
        header.createCell(4).setCellValue("Paper4");
        header.createCell(5).setCellValue("Paper5");
        header.createCell(6).setCellValue("Paper6");
        header.createCell(7).setCellValue("Paper7");
        header.createCell(8).setCellValue("Total");

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Student 1");
        row1.createCell(1).setCellValue(1);
        row1.createCell(2).setCellValue(7);
        row1.createCell(3).setCellValue(74);
        row1.createCell(4).setCellValue(23);
        row1.createCell(5).setCellValue(75);
        row1.createCell(6).setCellValue(55);
        row1.createCell(7).setCellValue(51);
        row1.createCell(8).setCellFormula("B2+C2+D2+E2+F2+G2+H2");

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("Student 2");
        row2.createCell(1).setCellValue(73);
        row2.createCell(2).setCellValue(17);
        row2.createCell(3).setCellValue(5);
        row2.createCell(4).setCellValue(52);
        row2.createCell(5).setCellValue(18);
        row2.createCell(6).setCellValue(26);
        row2.createCell(7).setCellValue(26);
        row2.createCell(8).setCellFormula("B3+C3+D3+E3+F3+G3+H3");

        Row row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue("Student 3");
        row3.createCell(1).setCellValue(27);
        row3.createCell(2).setCellValue(29);
        row3.createCell(3).setCellValue(29);
        row3.createCell(4).setCellValue(35);
        row3.createCell(5).setCellValue(96);
        row3.createCell(6).setCellValue(17);
        row3.createCell(7).setCellValue(45);
        row3.createCell(8).setCellFormula("B4+C4+D4+E4+F4+G4+H4");

        Row row4 = sheet.createRow(4);
        row4.createCell(0).setCellValue("Student 4");
        row4.createCell(1).setCellValue(4);
        row4.createCell(2).setCellValue(4);
        row4.createCell(3).setCellValue(56);
        row4.createCell(4).setCellValue(32);
        row4.createCell(5).setCellValue(12);
        row4.createCell(6).setCellValue(12);
        row4.createCell(7).setCellValue(14);
        row4.createCell(8).setCellFormula("B5+C5+D5+E5+F5+G5+H5");

        //Highlight:
//        for (int r=1; r<=4; r++){
//            Row rowcolor = sheet.createRow(r);
//            Cell cell = rowcolor.getCell(0,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//            cell.setCellStyle(blueStyle);
//        }
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("excelFormula_demo.xlsx"));
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Written excel demo.xlsx");
        } catch (Exception | IncompatibleClassChangeError e) {
            e.printStackTrace();
        }
    }
}
