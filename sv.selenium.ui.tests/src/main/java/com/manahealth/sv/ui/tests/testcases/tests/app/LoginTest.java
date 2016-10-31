package com.manahealth.sv.ui.tests.testcases.tests.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.manahealth.sv.ui.tests.framework.steps.app.LoginStep;
import com.manahealth.sv.ui.tests.testcases.tests.BaseTest;

public class LoginTest extends BaseTest {

	@DataProvider
	public String[][] wrongCredentials() {
		return new String[][] { { "qwerty@qwerty.ru", "qwerty" }, { "123456@123456.ru", "qwerty" } };
	}

	@DataProvider
	public String[][] credentials() {
		return new String[][] { { context.getUsername(), context.getPassword() }};
	}

	@Test(dataProvider = "wrongCredentials", description = "User can't be authorized with wrong credentials")
	public void loginWrongCreds(String username, String password) {
		LoginStep loginStep = new LoginStep(driver);
		loginStep.loginNegative(username, password);
	}

	@Test(dataProvider = "credentials", description = "User can be authorized, and see dashboard after authorization")
	public void loginPositive(String username, String password) {
		LoginStep loginStep = new LoginStep(driver);
		loginStep.login(username, password);
	}

}
