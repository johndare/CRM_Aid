package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.Base;

public class Utility extends Base
{
	public static final long imp_wait = 20;
	public static final long p_l_t = 20;
	
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static FileInputStream ip;
	public static Object[][] getData(String sheetName)
	{
		try {
			ip = new FileInputStream("F:/Selenium/Programs/CRM_Aid/src/main/java/excelData/FreeCRMTestData.xlsx");
			book = new XSSFWorkbook(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}	
		return data;
	}
	
	
	public static void takeScreenshotAtEndOfTest()
	{
		TakesScreenshot sht = (TakesScreenshot)driver;
		File src =sht.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots"+System.currentTimeMillis()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
