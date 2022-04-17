package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheet {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] readdata(String Sheetname){
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\15145\\eclipse-workspace\\HRmanagement\\src\\test\\java\\testdata\\New Microsoft Excel Worksheet.xlsx");
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file); //HSSF XSSF
		}
		catch(IOException a) {
			a.printStackTrace();
			
		}
	org.apache.poi.ss.usermodel.Sheet sheet=book.getSheet(Sheetname);
	
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for (int a=0;a<sheet.getLastRowNum();a++) {
		
		for (int b=0;b<sheet.getRow(0).getLastCellNum();b++) {
			
			data[a][b]=sheet.getRow(a+1).getCell(b).toString(); //
		}}
	return data;
	}}
	
	
    
    	
    	
    		
 
