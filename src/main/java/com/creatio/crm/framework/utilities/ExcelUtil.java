package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static List<Map<String, String>> readData2(String fileName, String sheetName)
	{
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		
		String filePath = System.getProperty("user.dir")+"//Files//"+fileName;
		
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sh = wb.getSheet(sheetName);//XSSFSheet sh = new XSSFSheet(wb);
			
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			
			for(int r=1; r< totalRows; r++)
			{
				Map<String,String> rowData = new HashMap<String, String>();
				for(int c=1; c< totalColumns; c++)
				{
					String cellColumn = sh.getRow(0).getCell(c).toString();
					String cellValue = sh.getRow(r).getCell(c).toString();
					rowData.put(cellColumn, cellValue);
					
				}
				data.add(rowData);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}

}
