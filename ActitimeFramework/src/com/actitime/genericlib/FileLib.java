package com.actitime.genericlib;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Ashutosh
 *
 */

public class FileLib {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Ashutosh\\eclipse-workspace\\ActitimeFramework\\Data\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Ashutosh\\eclipse-workspace\\ActitimeFramework\\Data\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;

	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public void setExcelData(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Ashutosh\\eclipse-workspace\\ActitimeFramework\\Data\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Ashutosh\\eclipse-workspace\\ActitimeFramework\\Data\\TestData.xlsx");
		wb.write(fos);
		wb.close();

	}
}
