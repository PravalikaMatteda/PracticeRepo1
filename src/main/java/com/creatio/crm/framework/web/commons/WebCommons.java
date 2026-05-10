package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.utilities.PropUtil;

public class WebCommons {
	
public WebDriver driver = new BasePage().getDriver();
	
	//not new BasePage.getDriver();
	
	public Properties prop = PropUtil.readData("config.properties");
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions action = new Actions(driver);
	
	//launchapplication
	//scroll
	//click
	//jsclick
	//doubleclick
	//click the hidden
	//enter text
	//enterInfo
	//checkbox
	//selectoption
	//wait
	//implicitwait
	//wati for alert
	//getText
	//getAttribute Value
	//visible
	//enable
	//swithc to frame(2 types)
	//switch to window
	//switch to default window
	//get window handle
	//getwindow handles
	
	
	public WebCommons(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new BasePage().getDriver(), this);
		
	}

	//launchapplication
	public void launchApplication() {
		driver.get(prop.getProperty("APP_URL"));//not prop.getProperty(APP_URL);
		Assert.assertEquals(driver.getTitle(), prop.getProperty("APP_TITLE"));
	}
	
		//scroll
	public void scrollUptoAnElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()", element);
		
	}
	
		//click
	public void safeClick(WebElement element)
	{
		scrollUptoAnElement(element);
		element.click();
	}
	
		//jsclick
	
	
		//doubleclick
	public void safeDoubleClick(WebElement element)
	{
		scrollUptoAnElement(element);
		action.doubleClick(element).perform();   //not action.doubleClick(element);
	}
	
		//click the hidden
	public void javascriptClick(WebElement element)
	{
		js.executeScript("arguments[0].click()",element);
	}
	
		//enter text
	public void safeEnterText(WebElement element,String text) {
		scrollUptoAnElement(element);
		element.clear();
		element.sendKeys(text);
	}
	
		//enterInfoIntoSuggestionBox
	public void safeInlineText(WebElement element, String text)
	{
		scrollUptoAnElement(element);
		element.clear();
		action.sendKeys(element,text).perform();
	}
	
	
		//checkbox//ignore
	public void checkBox1(WebElement element)
	{
		scrollUptoAnElement(element);
		if(!element.isSelected())
		{
			element.click();
		}
	}
	
	
	//try2
	public void checkBox(WebElement element, boolean status)
	{
		scrollUptoAnElement(element);
		if(element.isDisplayed() && element.isEnabled())
		{
			if(element.isSelected()!=status)//if selected and is it equal to what we want(status); if not
			{
				element.click();
			}
		}
	}
	
	
		//selectoption [dropdown]
	public void selectDropDownOption(WebElement element, String selectBy, String option)
	{
		scrollUptoAnElement(element);
		Select select = new Select(element);
		if(selectBy.equalsIgnoreCase("VisibleText"))
		{
			select.selectByVisibleText(option);
		}
		else if(selectBy.equalsIgnoreCase("Value"))
		{
			select.selectByValue(option);
		}
		else if(selectBy.equalsIgnoreCase("Index"))
		{
			select.selectByIndex(Integer.parseInt(option));//not selectByIndex(option)
		}
	}
	
	//implicitwait
	public void implicitWait(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
		//wait
	public void wait(By locator, int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,0)); //not "elementsToBeMoreThan"
	}
	
		//wati for alert
	public void waitForAlert(int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
		//getText
	public String getText(WebElement element)
	{
		scrollUptoAnElement(element);
		return element.getText();
	}
	
	
		//getAttribute Value
	public String getAttribute(WebElement element)
	{
		scrollUptoAnElement(element);
		return element.getAttribute("value");
	}
	
	
		//visible
		//enable
	
	
		//swithc to frame(2 types)
	public void switchToFrame(String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void defaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	
		//switch to window
	public void switchWindow(String windowTabOrWindow) //arguent should be string not "window"
	{
		driver.switchTo().window(windowTabOrWindow);
	}
	
		//switch to default window //this does not exist I guess
	
	
		//get window handle
	public String getCurrentWindowHandle()
	{
		return driver.getWindowHandle();
	}
	
		//getwindow handles
	public Set<String> getAllWindowHandles()
	{
		return driver.getWindowHandles();
	}
	
	// screenshot
	public void captureScreenshot1() throws IOException

	{
		String fileName = new SimpleDateFormat("yyyyMMDD_HH:MM:SS").format(new Date());
		
		String filePath = System.getProperty("user.dir")+"//Screenshots//"+"Screenshot_"+fileName+".png";//creation of filepath name
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//taking screenshot & storing in temp location
		
		File dest =new File(filePath);//creation dest file path with a path name
		
		FileUtils.copyFile(file, dest);//copying the screenshot in tmep location into destination file path created
		
	}
	
	
	public String captureScreenshot(WebDriver driver) throws IOException//not public void
	{
		//filepathname, fielpath, screenshot, place screenshot
		String fileName = new SimpleDateFormat("yyyyMMDD_H:M:S").format(new Date());
		String filePath = System.getProperty("user.dir")+"//Screenshot//"+"Screenshot"+fileName+".png";
		
		File dest = new File(filePath);
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file,dest);//method is copyFile ;not "copy"
		
		return filePath;
		
	}

}
