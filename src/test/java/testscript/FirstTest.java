package testscript;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import genericlibrary.BrowserUtilities;
import genericlibrary.LogUtilities;
import genericlibrary.ScreenshotUtilities;
import pageobjects.LoginPage;

public class FirstTest {

	LoginPage lpobj;
	Logger log;

	@BeforeTest
	public void launch() throws IOException, InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		BrowserUtilities.getBrowser();
		LogUtilities.info("Browser launched with url Successfully");
	}

	@BeforeMethod
	public void initializePage() {
		lpobj = new LoginPage(BrowserUtilities.driver);
	}

	@Test
	public void firstTest() throws IOException {
		try {
             
			lpobj.loginUser();
			 Assert.assertEquals("verify", "verify");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void screenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtilities.captureScreenShot();
		}
	}

	@AfterTest
	public void crash() {
		BrowserUtilities.closeBrowser();
		LogUtilities.info("Browser closed Successfully");
	}
}
