package com.tutorialsninja.qa.Pages.pt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameTextbox;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTextbox;

	@FindBy(id = "input-email")
	private WebElement emailTextbox;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTextbox;

	@FindBy(id = "input-password")
	private WebElement passwordTextbox;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextbox;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement newsletterYesRadioButton;

	@FindBy(xpath = "//div[contains(text(), 'Warning: E-Mail Address is already registered!')]")
	private WebElement actualExistingEmailWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Password confirmation does not match password!')]")
	private WebElement actualMismatchPasswordWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Warning: You must agree to the Privacy Policy!')]")
	private WebElement actualPrivacyPolicyWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")
	private WebElement actualFirstNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")
	private WebElement actualLastNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")
	private WebElement actualEmailWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")
	private WebElement actualTelephoneWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'Password must be between 4 and 20 characters!')]")
	private WebElement actualPasswordWarningMessage;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AccountSuccessPage enterMandatoryRegistrationDetails(String firstNameText, String lastNameText,
			String emailText, String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameTextbox.sendKeys(firstNameText);
		lastNameTextbox.sendKeys(lastNameText);
		emailTextbox.sendKeys(emailText);
		telephoneTextbox.sendKeys(telephoneText);
		passwordTextbox.sendKeys(passwordText);
		confirmPasswordTextbox.sendKeys(confirmPasswordText);
		privacyPolicyCheckbox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public AccountSuccessPage enterAllRegistrationDetails(String firstNameText, String lastNameText, String emailText,
			String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameTextbox.sendKeys(firstNameText);
		lastNameTextbox.sendKeys(lastNameText);
		emailTextbox.sendKeys(emailText);
		telephoneTextbox.sendKeys(telephoneText);
		passwordTextbox.sendKeys(passwordText);
		confirmPasswordTextbox.sendKeys(confirmPasswordText);
		newsletterYesRadioButton.click();
		privacyPolicyCheckbox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public void enterFirstName(String firstNameText) {
		firstNameTextbox.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNameTextbox.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailTextbox.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephoneTextbox.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordTextbox.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextbox.sendKeys(confirmPasswordText);
	}

	public void clickOnPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}

	public void clickNewsletterYesRadioButton() {
		newsletterYesRadioButton.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public String retrieveExistingEmailWarningMessage() {
		String existingEmailWarningMessage = actualExistingEmailWarningMessage.getText();
		return existingEmailWarningMessage;
	}

	public String retrieveMismatchPasswordWarningMessage() {
		String mismatchPasswordWarningMessage = actualMismatchPasswordWarningMessage.getText();
		return mismatchPasswordWarningMessage;
	}

	public String retrievePrivacyPolicyWarningMessage() {
		String privacyPolicyWarningMessage = actualPrivacyPolicyWarningMessage.getText();
		return privacyPolicyWarningMessage;
	}

	public String retrieveFirstNameWarningMessage() {
		String firstNameWarningMessage = actualFirstNameWarningMessage.getText();
		return firstNameWarningMessage;
	}

	public String retrieveLastNameWarningMessage() {
		String lastNameWarningMessage = actualLastNameWarningMessage.getText();
		return lastNameWarningMessage;
	}

	public String retrieveEmailWarningMessage() {
		String emailWarningMessage = actualEmailWarningMessage.getText();
		return emailWarningMessage;
	}

	public String retrieveTelephoneWarningMessage() {
		String telephoneWarningMessage = actualTelephoneWarningMessage.getText();
		return telephoneWarningMessage;
	}

	public String retrievePasswordWarningMessage() {
		String passwordWarningMessage = actualPasswordWarningMessage.getText();
		return passwordWarningMessage;
	}
}