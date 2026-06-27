package DataDriven;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("./src/main/resources/TestData21.xlsx");
        Workbook wb = WorkbookFactory.create(fis);

        Sheet data = wb.getSheet("Products");
        Row row = data.getRow(1);
        String productName = row.getCell(2).getStringCellValue();
        System.out.println(productName);


    }
}
