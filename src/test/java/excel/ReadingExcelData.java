package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./testData//employee.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		int data = workbook.getSheet("Sheet1").getLastRowNum();
		for (int i = 1; i <= data-1; i++) {
			
			int employee_id = (int) workbook.getSheet("Sheet1").getRow(i).getCell(0).getNumericCellValue();
			String employee_name = workbook.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			double salary = workbook.getSheet("Sheet1").getRow(i).getCell(2).getNumericCellValue();
			String designation = workbook.getSheet("Sheet1").getRow(i).getCell(3).getStringCellValue();
			String department = workbook.getSheet("Sheet1").getRow(i).getCell(4).getStringCellValue();

			System.out.println(employee_id + " " +employee_name + " " + salary + " " + designation + " " + department);

		}
		fis.close();

	}

}
