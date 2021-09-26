package com.forsys.rise.commonTests;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.forsys.automation.selenium.WebDriverUtils;
import com.forsys.automation.ui.UIAutomator;
import com.forsys.automation.utils.Utility;
import com.forsys.rise.ui.HomePage;
import com.forsys.rise.ui.LoginPage;
import com.forsys.rise.ui.StartUpPage;

public class BaseTest {
	// Helper objects
	public WebDriver driver;
	public Properties configProperties;
	public Properties properties;
	public String accessToken;

	public String instanceURL;
	public String keyPrefix;
	public String accountId = "";

	// Ui pages
	public UIAutomator riseUI;
	public StartUpPage startUpPage;
	public LoginPage loginPage;
	public HomePage homePage;

	public Map<String, String> loginTestData = new HashMap<String, String>();

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "environment" })
	public void loadData(String environment) throws Exception {
		properties = new Utility().loadPropertyFile(environment);
		loginTestData.put("url", properties.getProperty("SFURL"));
		loginTestData.put("client_id", properties.getProperty("clientid"));
		loginTestData.put("client_secret", properties.getProperty("clientsecret"));
		loginTestData.put("username", properties.getProperty("LoginUser"));
		loginTestData.put("password", properties.getProperty("LoginPassword"));
	}

	@BeforeClass(alwaysRun = true)
	@Parameters({ "runParallel", "environment", "browser", "hubURL" })
	public void LoginToAdminApp(String runParallel, String environment, String browser, String hubURL)
			throws Exception {
		properties = new Utility().loadPropertyFile(environment);
		WebDriverUtils utils = new WebDriverUtils();
		utils.initializeDriver(browser, hubURL);
		this.driver = utils.getDriver();

		startUpPage = new StartUpPage(driver);
		loginPage = startUpPage.navigateToPage(properties.getProperty("baseURL"));

		// properties.forEach((k, v) ->
		// testData.put(String.format("%s",k),String.format("%s",v)));

		riseUI = new UIAutomator(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void deleteData(Method testMethod) throws Exception {
		try {
			// closed open tabs if any
			String originalHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(originalHandle)) {
					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandle);
			// Delete data with reference of accountid
			if (accountId != "") {
				Map<String, String> queriesBlock = new Utility().readJsonElement("deleteTestData.json", "deleteData");
				// billingapiHelper.deleteData(accountId,queriesBlock);
			}
			// Navigate to home page
			driver.get(instanceURL);
		} catch (Exception e) {
			Reporter.log("Exception observed while loading instance URL or deletion of data :: " + e.toString());
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		try {
			this.driver.quit();
		} catch (Exception e) {
			Reporter.log("Exception observed killing driver operation :: " + e.toString());
		}
	}

	@AfterSuite(alwaysRun = true)
	public void deleteDataWithPrefix() throws Exception {
		try {

		} catch (Exception e) {
			Reporter.log("Exception observed while loading instance URL or deletion of data :: " + e.toString());
		}

	}
}