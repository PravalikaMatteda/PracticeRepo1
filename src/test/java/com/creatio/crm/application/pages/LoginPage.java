package com.creatio.crm.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.web.commons.WebCommons;

public class LoginPage{
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new BasePage().getDriver(), this);//*
	}

	

	@FindBy(xpath = "//input[@name='username']")
	public WebElement webEdt_UserName;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement webEdt_Password;
	
	@FindBy(xpath = "//button[@type='submit' and contains(@class,'login')]")
	public WebElement webBtn_Login;
	
	

}
