package com.api.Reading;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static List<List<Object>> readRequest() {
		List<List<Object>> requests = new ArrayList<>();// creating a list(arrayList) of lists  

		try {
			String path = System.getProperty("user.dir") + "//src//test//resources//TestData1.xlsx";//path of excel file
			FileInputStream fis = new FileInputStream(new File(path));// to read the excel file 
			XSSFWorkbook book = new XSSFWorkbook(fis);// workbook object which represents excel book 
			XSSFSheet sheet = book.getSheetAt(0);// getting a page from the book 
			int endRow = sheet.getLastRowNum();// this returns the index of last row
			
			// iterating for each row from row number 2
			for (int i = 1; i <= endRow; i++) 
			{
				List<Object> tmp = new ArrayList<>();
				Row row = sheet.getRow(i);
				tmp.add(row.getCell(1));
				tmp.add(row.getCell(2));
				tmp.add(row.getCell(3));
				if(row.getCell(4)!=null ||row.getCell(5)!=null)
				{
					tmp.add(row.getCell(4).getNumericCellValue());
					tmp.add(row.getCell(5).getNumericCellValue());
					
				}
				
				tmp.add(row.getCell(6));
				tmp.add(row.getCell(7));
				tmp.add(row.getCell(8));
				requests.add(tmp);
			}

			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return requests;//this returns the whole 2d arrayList of inputData to the caller method
	}
}