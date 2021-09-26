package com.forsys.rise.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.forsys.automation.ui.UIAutomator;

public class StartUpPage {

	public WebDriver driver;
	public WebDriverWait wbwait;
	public UIAutomator riseUI;

	public int waitTime = 30;

	public StartUpPage(WebDriver driver) {
		this.driver=driver;
		riseUI=new UIAutomator(driver);
	}
	
	public void killDriver() {
		this.driver.quit();
	}
	
	public LoginPage navigateToPage(String url) throws Exception {
		riseUI.maximizeWindow()
				  .navigateTo(url);
		return PageFactory.initElements(this.driver, LoginPage.class);
	}
	
	public void waitTillStaleElementToBeVisible(WebElement element) {
		new WebDriverWait(driver, waitTime)
				.until(ExpectedConditions.refreshed(
						ExpectedConditions.visibilityOf(element)));
	}
	
	public boolean elementIsVisible(WebElement elementTobeVisible)      
    {
        try
        {
            riseUI.waitTillElementIsVisible(elementTobeVisible);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
	
	public boolean elementIsClickable(WebElement elementTobeClickable)      
    {
        try
        {
            riseUI.waitTillElementIsClickable(elementTobeClickable);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
	
	public boolean elementIsVisible(By String)      
    {
        try
        {
            riseUI.waitTillElementIsVisible(String);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
	

}