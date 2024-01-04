package com.tutorialsninja.qa.TestCases.pt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.pt2.CheckoutPage;
import com.tutorialsninja.qa.Pages.pt2.HomePage;
import com.tutorialsninja.qa.Pages.pt2.OrderSuccessPage;
import com.tutorialsninja.qa.Pages.pt2.SearchPage;
import com.tutorialsninja.qa.Pages.pt2.ValidProductPage;
import com.tutorialsninja.qa.TestBase.pt2.TestBase;

public class AddToCartTest extends TestBase {

	public AddToCartTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;
	public ValidProductPage validproductpage;
	public CheckoutPage checkoutpage;
	public OrderSuccessPage ordersuccesspage;
	public Select select;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void addValidProductToCartTest() throws Exception {
		searchpage = homepage.searchProduct(dataProp.getProperty("validProduct"));
		validproductpage = searchpage.clickOnValidProductLink();
		Assert.assertTrue(validproductpage.verifyProductDescriptionDisplayStatus());
		validproductpage.clickOnAddToCartButton();
		String actualAddedToCartSuccessMessage = validproductpage.retrieveAddedToCartSuccessMessage();
		Thread.sleep(3000);
		String expectedAddedToCartSuccessMessage = dataProp.getProperty("expectedAddedToCartSuccessMessage");
		Assert.assertTrue(actualAddedToCartSuccessMessage.contains(expectedAddedToCartSuccessMessage));
		validproductpage.clickOnShoppingCartButton();
		checkoutpage = validproductpage.clickOnCheckoutLink();
		checkoutpage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Thread.sleep(3000);
		checkoutpage.clickOnNewAddressRadioButton();
		checkoutpage.enterBillingDetails(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				dataProp.getProperty("Company"), dataProp.getProperty("Address1"), dataProp.getProperty("City"),
				dataProp.getProperty("PostCode"));
		select = new Select(checkoutpage.Country);
		select.selectByVisibleText(dataProp.getProperty("Country"));
		select = new Select(checkoutpage.State);
		select.selectByVisibleText(dataProp.getProperty("State"));
		checkoutpage.clickOnBillingDetailsContinueButton();
		select = new Select(checkoutpage.existingAddressOption);
		select.selectByVisibleText(dataProp.getProperty("fullShippingInfo"));
		checkoutpage.clickOnDeliveryDetailsContinueButton();
		checkoutpage.clickOnDeliveryMethodContinueButton();
		checkoutpage.clickOnTermsAndConditionsCheckbox();
		checkoutpage.clickOnPaymentMethodContinueButton();
		ordersuccesspage = checkoutpage.clickOnConfirmOrderButton();
		String actualOrderPlacedSuccessMessage = ordersuccesspage.retrieveOrderPlacedSuccessMessage();
		String expectedOrderPlacedSuccessMessage = dataProp.getProperty("expectedOrderPlacedSuccessMessage");
		Assert.assertEquals(actualOrderPlacedSuccessMessage, expectedOrderPlacedSuccessMessage);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}