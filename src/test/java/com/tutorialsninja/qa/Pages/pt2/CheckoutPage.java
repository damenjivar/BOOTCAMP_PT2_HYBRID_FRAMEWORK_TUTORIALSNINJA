package com.tutorialsninja.qa.Pages.pt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	public WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailTextbox;

	@FindBy(id = "input-password")
	private WebElement passwordTextbox;

	@FindBy(css = "input#button-login")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class = 'col-sm-12']/descendant::input[2]")
	private WebElement newAddressRadioButton;

	@FindBy(id = "input-payment-firstname")
	private WebElement firstName;

	@FindBy(id = "input-payment-lastname")
	private WebElement lastName;

	@FindBy(id = "input-payment-company")
	private WebElement companyName;

	@FindBy(id = "input-payment-address-1")
	private WebElement address1;

	@FindBy(id = "input-payment-city")
	private WebElement City;

	@FindBy(id = "input-payment-postcode")
	private WebElement postCode;

	@FindBy(id = "input-payment-country")
	public WebElement Country;

	@FindBy(id = "input-payment-zone")
	public WebElement State;

	@FindBy(id = "button-payment-address")
	private WebElement billingDetailsContinueButton;

	@FindBy(xpath = "//div[@id = 'shipping-existing']/select[@name = 'address_id']")
	public WebElement existingAddressOption;

	@FindBy(id = "button-shipping-address")
	private WebElement deliveryDetailsContinueButton;

	@FindBy(id = "button-shipping-method")
	private WebElement deliveryMethodContinueButton;

	@FindBy(name = "agree")
	private WebElement termsAndConditions;

	@FindBy(id = "button-payment-method")
	private WebElement paymentMethodContinueButton;

	@FindBy(id = "button-confirm")
	private WebElement confirmOrderButton;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public OrderSuccessPage clickOnConfirmOrderButton() {
		confirmOrderButton.click();
		return new OrderSuccessPage(driver);
	}

	public void clickOnPaymentMethodContinueButton() {
		paymentMethodContinueButton.click();
	}

	public void clickOnTermsAndConditionsCheckbox() {
		termsAndConditions.click();
	}

	public void clickOnDeliveryMethodContinueButton() {
		deliveryMethodContinueButton.click();
	}

	public void login(String emailText, String passwordText) {
		emailTextbox.sendKeys(emailText);
		passwordTextbox.sendKeys(passwordText);
		loginButton.click();
	}

	public void clickOnNewAddressRadioButton() {
		newAddressRadioButton.click();
	}

	public void enterBillingDetails(String firstNameText, String lastNameText, String companyNameText,
			String address1Text, String cityNameText, String postCodeText) {
		firstName.sendKeys(firstNameText);
		lastName.sendKeys(lastNameText);
		companyName.sendKeys(companyNameText);
		address1.sendKeys(address1Text);
		City.sendKeys(cityNameText);
		postCode.sendKeys(postCodeText);
	}

	public void clickOnBillingDetailsContinueButton() {
		billingDetailsContinueButton.click();
	}

	public void clickOnDeliveryDetailsContinueButton() {
		deliveryDetailsContinueButton.click();
	}
}