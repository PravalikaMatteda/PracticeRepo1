package com.creatio.crm.application.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.creatio.crm.application.actions.LoginActions;
import com.creatio.crm.application.pages.HomePage;
import com.creatio.crm.application.pages.LoginPage;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.web.commons.WebCommons;

public class BaseTest {
	LoginActions loginActions;
	//WebCommons webCommons;

	
	@BeforeMethod(alwaysRun=true)
	public void initializePages()
	{
		WebDriver driver = new BasePage().getDriver();
		loginActions = new LoginActions(driver);
	}

}
