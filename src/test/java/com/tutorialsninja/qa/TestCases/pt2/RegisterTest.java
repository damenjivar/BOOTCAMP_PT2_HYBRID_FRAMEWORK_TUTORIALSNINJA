package com.tutorialsninja.qa.TestCases.pt2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.pt2.AccountSuccessPage;
import com.tutorialsninja.qa.Pages.pt2.HomePage;
import com.tutorialsninja.qa.Pages.pt2.RegisterPage;
import com.tutorialsninja.qa.TestBase.pt2.TestBase;
import com.tutorialsninja.qa.Utilities.pt2.Util;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		registerpage = homepage.navigateToRegisterPage();
	}

	@Test(priority = 1)
	public void verifyRegisterWithMandatoryFields() {
		accountsuccesspage = registerpage.enterMandatoryRegistrationDetails(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountsuccesspage.retrieveAccountCreatedSuccessMessage(),
				dataProp.getProperty("expectedAccountCreatedSuccessMessage"));
	}

	@Test(priority = 2)
	public void verifyRegisterWithAllFields() {
		accountsuccesspage = registerpage.enterAllRegistrationDetails(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountsuccesspage.retrieveAccountCreatedSuccessMessage(),
				dataProp.getProperty("expectedAccountCreatedSuccessMessage"));
	}

	@Test(priority = 3)
	public void verifyRegisterWithNoFields() {
		registerpage.clickOnContinueButton();
		Assert.assertEquals(registerpage.retrievePrivacyPolicyWarningMessage(),
				dataProp.getProperty("expectedPrivacyPolicyWarningMessage"));

		Assert.assertEquals(registerpage.retrieveFirstNameWarningMessage(),
				dataProp.getProperty("expectedFirstNameWarningMessage"));

		Assert.assertEquals(registerpage.retrieveLastNameWarningMessage(),
				dataProp.getProperty("expectedLastNameWarningMessage"));

		Assert.assertEquals(registerpage.retrieveEmailWarningMessage(),
				dataProp.getProperty("expectedEmailWarningMessage"));

		Assert.assertEquals(registerpage.retrieveTelephoneWarningMessage(),
				dataProp.getProperty("expectedTelephoneWarningMessage"));

		Assert.assertEquals(registerpage.retrievePasswordWarningMessage(),
				dataProp.getProperty("expectedPasswordWarningMessage"));
	}

	@Test(priority = 4)
	public void verifyRegisterWithExistingEmail() {
		registerpage.enterAllRegistrationDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephone"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));
		Assert.assertEquals(registerpage.retrieveExistingEmailWarningMessage(),
				dataProp.getProperty("expectedExistingEmailWarningMessage"));
	}

	@Test(priority = 5)
	public void verifyRegisterWithMismatchPassword() {
		registerpage.enterAllRegistrationDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"),
				dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(registerpage.retrieveMismatchPasswordWarningMessage(),
				dataProp.getProperty("expectedMismatchPasswordWarningMessage"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}