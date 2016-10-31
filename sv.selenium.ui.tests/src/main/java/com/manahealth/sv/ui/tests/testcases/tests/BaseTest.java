package com.manahealth.sv.ui.tests.testcases.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.manahealth.sv.ui.tests.framework.driver.Context;
import com.manahealth.sv.ui.tests.framework.driver.DriverFactory;
import com.manahealth.sv.ui.tests.framework.driver.DriverType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class BaseTest {

	protected WebDriver driver = null;
	protected Context context = null;
	ExtentReports extent = new ExtentReports("D:/report.html");

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		DriverFactory.quitWebDriver(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void startUp() {
		ExtentTest test = extent.startTest("Test Name", "Sample description");
		extent.startTest("Test Name", "Sample description");
		test.log(LogStatus.PASS, "Step details");
		extent.endTest(test);
		extent.flush();
		driver = DriverFactory.getWebDriver(context.getDriver());
		driver.get(context.getBaseUrl());
	}

	@Parameters({ "BASE_URL", "USERNAME", "PASSWORD", "DRIVER" })
	@BeforeClass
	public void setUpContext(@Optional String baseUrl, @Optional String username, @Optional String password,
			@Optional String driver) {
		context = Context.getInstance();
		context.setBaseUrl(baseUrl);
		context.setDriver(DriverType.valueOf(driver));
		context.setUsername(username);
		context.setPassword(password);
	}
}
