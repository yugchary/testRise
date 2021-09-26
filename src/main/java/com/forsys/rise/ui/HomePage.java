package com.forsys.rise.ui;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends StartUpPage {

	@FindAll({@FindBy(css="a[title='Agreements']~* a[role='button']"),
	          @FindBy(css="a[title='Agreements Tab']")})
	@CacheLookup
	public WebElement mnuAgreements;
	
	@FindBy(css="a[title='Templates']~* a[role='button']")
	@CacheLookup
	public WebElement mnuTemplates;
	
	@FindBy(css="a[title='Dashboards']~* a[role='button']")
	@CacheLookup
	public WebElement mnuDashboards;
	
	@FindBy(css="a[title='Reports']~* a[role='button']")
	@CacheLookup
	public WebElement mnuReports;
	
	@FindBy(css="a[title='Contacts']~* a[role='button']")
	@CacheLookup
	public WebElement mnuContacts;
	
	@FindBy(css="a[title='Obligations']~* a[role='button']")
	@CacheLookup
	public WebElement mnuObligations;
	
	@FindBy(css="span")
	public List<WebElement> lnkNewAgreement;
	
	@FindAll({@FindBy(linkText="New Agreement"),@FindBy(css="input[name='new']")})
	public WebElement lnkNewAgreement1;
	
	@FindBy(css="h2.title")
	@CacheLookup
	public WebElement headerNewAgreement;
	
	@FindBy(css="label>div")
	@CacheLookup
	public List<WebElement> rdbAllRadioButtons;
	
	@FindAll({@FindBy(css=".modal-footer button"),@FindBy(css="input")})
	@CacheLookup
	public List<WebElement> btnmodalButtons;
	
	@FindBy(css="input[value='Continue']")
	@CacheLookup
	public WebElement btnContinue;
	
	@FindBy(css="div.changeRecordTypeItemDescription")
	@CacheLookup
	public WebElement rdbPopUp;
	
	@FindBy(id="p3")
	@CacheLookup
	public WebElement ddlRecordType;
	
	@FindAll({@FindBy(css=".chartBody"),@FindBy(id="bodyCell")})
	@CacheLookup
	public WebElement chartHome;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage waitForHomePageToLoad() throws Exception {
		riseUI.waitTillElementIsVisible(chartHome);
		return PageFactory.initElements(driver, HomePage.class);
	}
 
	
}