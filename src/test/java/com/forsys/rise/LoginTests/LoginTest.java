package com.forsys.rise.LoginTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.forsys.automation.exception.CustomException;
import com.forsys.rise.commonTests.BaseTest;

public class LoginTest extends BaseTest {

	public Map<String, String> billIdsBillingSchedulePage = new HashMap<String, String>();
	public Map<String, String> billIdsInvoicePage = new HashMap<String, String>();
	public Map<String, String> assetLineData = new HashMap<String, String>();

	/**
	 * TC2080 Valid product configuration id, valid billing template id
	 *
	 * @throws Exception
	 */
	@Test(description = "Test the rise Logn", groups = { "Yug" })
	public void testLogin() throws Exception {

		try {

			System.out.println("Title:" + riseUI.getTitle());

			Assert.assertEquals(riseUI.getTitle(), "Rise");

		} catch (Exception e) {
			throw new CustomException(e.toString());
		}
	}

	@Test(description = "Test the rise Logn", groups = { "Yug" })
	public void testLogin2() throws Exception {

		try {

			System.out.println("Title:" + riseUI.getTitle());

			Assert.assertEquals(riseUI.getTitle(), "Rise");

		} catch (Exception e) {
			throw new CustomException(e.toString());
		}
	}
}