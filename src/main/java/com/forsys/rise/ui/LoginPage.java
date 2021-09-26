package com.forsys.rise.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StartUpPage
{

	
	@FindBy(name="username")
	@CacheLookup
	public WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	public WebElement txtPassword;
		
	@FindBy(css="[class='loginCheck']")
	@CacheLookup
	public WebElement btnLogin;
		
	String classicPageHomeButton="//ul[@id='tabBar']/descendant::a[text()='Home']";
	String lightningPageProfileImageIcon="//span[contains(@class,'forceSocialPhoto')]/descendant::span[@class='uiImage']";
	String switchToClassicLink="//a[text()='Switch to Salesforce Classic']";

	

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage waitForLoginPageLoad() throws Exception {
		riseUI.waitTillElementIsVisible(btnLogin)
				   .waitTillElementIsClickable(btnLogin);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public HomePage loginToApp(String username,String password) throws Exception {
		txtUserName.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		/**
		 * Below Lines of code is to check if the logged in page is classic or lightning.
		 * If lightning then switch back to classic.
		 **/
		PageFactory.initElements(driver, LoginPage.class);
		riseUI.waitTillElementIsVisible(By.xpath("//*[text()='Home']"));
		if(riseUI.findTheElements(By.xpath(classicPageHomeButton)).size()==0) {
			System.out.println("  ======= Switching from Lightning to Classic Sales Force ====== ");
			riseUI.waitTillElementIsVisible(By.xpath(lightningPageProfileImageIcon))
					   .waitTillElementIsClickable(By.xpath(lightningPageProfileImageIcon))
					   .click(By.xpath(lightningPageProfileImageIcon))
					   .waitTillElementIsVisible(By.xpath(switchToClassicLink))
					   .waitTillElementIsClickable(By.xpath(switchToClassicLink))
					   .click(By.xpath(switchToClassicLink))
					   .waitTillElementIsVisible(By.xpath(classicPageHomeButton))
					   .waitTillElementIsClickable(By.xpath(classicPageHomeButton));
			System.out.println("  ======= Switched Back to SF Classic ====== ");		
		}
		return PageFactory.initElements(driver, HomePage.class);
	}  
}
