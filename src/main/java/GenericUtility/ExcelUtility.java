package GenericUtility;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtility {
    public String toReadDataFromExcel(String sheetname, int rowno, int cellno) throws Throwable
    {
        FileInputStream fis = new FileInputStream("src/main/resources/TestData21.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        String data = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
        return data;
    }
}
