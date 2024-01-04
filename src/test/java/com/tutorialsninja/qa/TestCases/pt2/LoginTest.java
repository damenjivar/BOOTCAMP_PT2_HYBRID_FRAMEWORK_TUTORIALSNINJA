package com.tutorialsninja.qa.TestCases.pt2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.pt2.AccountPage;
import com.tutorialsninja.qa.Pages.pt2.HomePage;
import com.tutorialsninja.qa.Pages.pt2.LoginPage;
import com.tutorialsninja.qa.TestBase.pt2.TestBase;
import com.tutorialsninja.qa.Utilities.pt2.Util;
import com.tutorialsninja.qa.testData.pt2.ExcelCode;

public class LoginTest extends TestBase {

	LoginTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		loginpage = homepage.navigateToLoginPage();
	}

	@Test(priority = 1, dataProvider = "TNLogin", dataProviderClass = ExcelCode.class)
	public void verifyLoginWithValidCredentials(String username, String password) {
		accountpage = loginpage.enterLoginCredentials(username, password);
		Assert.assertTrue(accountpage.verifyDisplayStatusOfEditYourAccountInfoLink());
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginpage.enterLoginCredentials(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginpage.retrieveExpectedNoMatchEmailPasswordWarningMessage(),
				dataProp.getProperty("expectedNoMatchEmailPasswordWarningMessage"));
	}

	@Test(priority = 3)
	public void verifyLoginWithValidEmailInvalidPassword() {
		loginpage.enterLoginCredentials(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginpage.retrieveExpectedNoMatchEmailPasswordWarningMessage(),
				dataProp.getProperty("expectedNoMatchEmailPasswordWarningMessage"));
	}

	@Test(priority = 4)
	public void verifyLoginWithInvalidEmailValidPassword() {
		loginpage.enterLoginCredentials(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertEquals(loginpage.retrieveExpectedNoMatchEmailPasswordWarningMessage(),
				dataProp.getProperty("expectedNoMatchEmailPasswordWarningMessage"));
	}

	@Test(priority = 5)
	public void verifyLoginWithNoCredentials() {
		loginpage.clickOnLoginButton();
		Assert.assertEquals(loginpage.retrieveExpectedNoMatchEmailPasswordWarningMessage(),
				dataProp.getProperty("expectedNoMatchEmailPasswordWarningMessage"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}