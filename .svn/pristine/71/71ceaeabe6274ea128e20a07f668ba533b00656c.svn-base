package com.test.automation.UIAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	String path = null;
	public DataFormatter formatter = new DataFormatter();
	
	
	
	// Constructor
	public excelReader() throws IOException {
		path = System.getProperty("user.dir") + "\\resources\\excel\\testdata.xlsx";
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
	}

	// Provides total number of rows in sheet - testcase
	public int getSheetRows(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		return (sheet.getLastRowNum() + 1);
	}

	// Provide total number of columns in sheet - testcase
	public int getSheetColumns(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		return (row.getLastCellNum());
	}

	// Provide cell value - testdata
	public String getCellData(String sheetName, int colNum, int rowNum) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		return (cell.getStringCellValue());
	}

	// Provide cell value - testdata
	public String getCellData(String sheetName, String colName, int rowNum) {
		int colNum = -1;
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		for (int i = 0; i < getSheetColumns(sheetName); i++) {
			row = sheet.getRow(0);
			cell = row.getCell(i);
			if (cell.getStringCellValue().equals(colName))
			{
				colNum = cell.getColumnIndex();
				break;
			}
		}
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		return (cell.getStringCellValue());
	}

	public void setCellData(String sheetName, int colNum, int rowNum, String str) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(str);
		try {
			fileOut = new FileOutputStream(path);
			try {
				workbook.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
