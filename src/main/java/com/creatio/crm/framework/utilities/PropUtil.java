package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
	
	public static Properties readData(String fileName) 
	{
		Properties prop = new Properties();//1
		
		String filePath = System.getProperty("user.dir")+"//Config//"+fileName;//5
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//4
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//3
		
		return prop;//2
	}

}
