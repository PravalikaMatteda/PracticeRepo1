package com.creatio.crm.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.framework.base.BasePage;

public class HomePage{
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new BasePage().getDriver(), this);//*
	}

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	public WebElement webElmnt_Profile;
	
	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement webElmnt_Logout;

}
