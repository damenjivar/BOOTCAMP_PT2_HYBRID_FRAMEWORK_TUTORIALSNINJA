package com.tutorialsninja.qa.TestCases.pt2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.pt2.HomePage;
import com.tutorialsninja.qa.Pages.pt2.SearchPage;
import com.tutorialsninja.qa.TestBase.pt2.TestBase;

public class SearchProductTest extends TestBase {

	public SearchProductTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		searchpage = homepage.searchProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchpage.verifyActualValidProductIsDisplayed());
	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		searchpage = homepage.searchProduct(dataProp.getProperty("invalidProduct"));
		String actualNoProductMatchSearchCriteriaWarningMessage = homepage
				.retrieveNoProductMatchSearchCriteriaWarningMessage();
		String expectedNoProductMatchSearchCriteriaWarningMessage = dataProp
				.getProperty("expectedNoProductMatchSearchCriteriaWarningMessage");
		Assert.assertEquals(actualNoProductMatchSearchCriteriaWarningMessage,
				expectedNoProductMatchSearchCriteriaWarningMessage);
	}

	@Test(priority = 3)
	public void verifySearchWithNoProduct() {
		homepage.clickOnSearchButton();
		String actualNoProductMatchSearchCriteriaWarningMessage = homepage
				.retrieveNoProductMatchSearchCriteriaWarningMessage();
		String expectedNoProductMatchSearchCriteriaWarningMessage = dataProp
				.getProperty("expectedNoProductMatchSearchCriteriaWarningMessage");
		Assert.assertEquals(actualNoProductMatchSearchCriteriaWarningMessage,
				expectedNoProductMatchSearchCriteriaWarningMessage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}