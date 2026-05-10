package com.creatio.crm.application.actions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.pages.HomePage;
import com.creatio.crm.application.pages.LoginPage;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.web.commons.WebCommons;

public class LoginActions extends Reports{
	
	
	Properties prop = new Properties();
	WebCommons webCommons;
    LoginPage loginPage;
    HomePage homePage;
	
	
	public LoginActions(WebDriver driver)//should be constructor
	{
		PageFactory.initElements(new BasePage().getDriver(), this);//*
		 webCommons = new WebCommons(driver);   // ✅ initialize
	        loginPage = new LoginPage(driver);     // ✅ initialize
	        homePage = new HomePage(driver);
		
	}
	
	
	public void loginProcess()
	{
		
		String username = prop.getProperty("UserName");
		String password = prop.getProperty("Password");
		webCommons.safeEnterText(loginPage.webEdt_UserName,username);
		//log( "",  "");
		log("info", "entered User Name");
		webCommons.safeEnterText(loginPage.webEdt_Password,password);
		webCommons.safeClick(loginPage.webBtn_Login);
		log("pass", "Clicked on Login");
		
	}
	
	
	public void logOutProcess()
	{
		webCommons.safeClick(homePage.webElmnt_Profile);
		//webCommons.wait(loginPage.webElmnt_Logout, 3);
		webCommons.safeClick(homePage.webElmnt_Logout);
		
	}

}
