package com.creatio.crm.framework.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	public static ResultSet readData(String query)
	{
		Properties prop;
		ResultSet rawData = null;
		try {
			prop = PropUtil.readData("config.properties");
			String dbUrl = prop.getProperty("DB_URL");
			String dbUserName = prop.getProperty("DB_UserName");
			String dbPassword = prop.getProperty("DB_Password");

			Connection connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			rawData = connection.createStatement().executeQuery(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rawData;
	
	}

}
