package exercise1;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
public class ExcelWriteSample {
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Employee Data");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1",new Object[]{"ID","NAME","LAST NAME"});
        data.put("2",new Object[]{1,"Amit","Shukla"});
        data.put("3",new Object[]{2,"Lokesh","Gupta"});
        data.put("4",new Object[]{3,"John","Adwards"});
        data.put("5",new Object[]{4,"Brian","Schultz"});
        Set<String> keys = data.keySet();
        int rownum = 0;
        for (String key : keys) {
            Row row = sheet.createRow(rownum++);
            Object[] values = data.get(key);
            int cellnum = 0;
            for (Object value : values) {
                Cell cell = row.createCell(cellnum++);
                if (value instanceof String) cell.setCellValue((String) value);
                else if (value instanceof Integer) cell.setCellValue((Integer) value);
            }
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(new File("excel_demo.xlsx"));
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Written excel demo.xlsx");
        } catch (Exception | IncompatibleClassChangeError e) {
            e.printStackTrace();
        }
    }
}
