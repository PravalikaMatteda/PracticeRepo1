package com.creatio.crm.application.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.creatio.crm.application.actions.LoginActions;
import com.creatio.crm.framework.base.BasePage;

public class LoginTest extends BaseTest{
	
	//LoginActions loginActions = new LoginActions();
	
	@Test(priority=1)
	public void Login()
	{
		System.out.println("entered 'Login' - method");
		loginActions.loginProcess();
		loginActions.logOutProcess();
	}

}
