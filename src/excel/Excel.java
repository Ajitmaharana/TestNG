package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static void main(String[] args)throws Exception {
		//Read
		Workbook w=WorkbookFactory.create(new FileInputStream("./input/Book1.xlsx"));
		String v=w.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(v);
		//Write
		w.getSheet("sheet1").getRow(0).getCell(0).setCellValue("Ajit");
		//w.getSheet("Sheet1").createRow(1).createCell(0).setCellValue("Ajit");
		w.write(new FileOutputStream("./input/Book2.xlsx")); //diff path->Save as
		w.close();
	}

}
