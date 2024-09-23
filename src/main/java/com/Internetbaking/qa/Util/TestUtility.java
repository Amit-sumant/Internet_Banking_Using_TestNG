package com.Internetbaking.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Intenerbanking.qa.Base.TestBase;

public class TestUtility extends TestBase
{
	/**
	 * 
	 * @throws IOException.
	 */
	public TestUtility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long Page_Load_Timeout = 10;
	public static long Implicit_Wait = 10;
	
	public void switchToFrame()
	{
		driver.switchTo().frame(0);
	}
	
	public static void getDatafromExcel() throws IOException
	{
		String xlsFile = ".//DataFiles//Customer.xlsx";
		FileInputStream fis=new FileInputStream(xlsFile);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis); //from this workbook, we get a sheet. So next line get shet
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//now we need to read.Using loop
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		for(int r=0;r<rows;r++)
		{
			XSSFRow row =  sheet.getRow(r); //get the row
			
			for(int c=0;c<cols;c++) // represent cells
			{
				XSSFCell cell =  row.getCell(c);
				
				switch(cell.getCellType())
				{
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
					
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				}
			}
			System.out.println();
		}
	}

}
