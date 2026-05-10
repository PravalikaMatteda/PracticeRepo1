package com.creatio.crm.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage {
	
private static WebDriver driver = null;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({"BROWSER"})
	public void setUpBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			Assert.fail("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDownBrowser() {
		driver.quit();
		
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void setDriver(WebDriver newDriver)
	{
		//driver = new newDriver;//wrong
		driver = newDriver;
	}

}
