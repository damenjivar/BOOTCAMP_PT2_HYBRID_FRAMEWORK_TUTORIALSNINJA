package com.tutorialsninja.qa.Pages.pt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchTextbox;

	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	@FindBy(xpath = "//p[contains(text(), 'There is no product that matches the search criteria.')]")
	private WebElement actualNoProductMatchSearchCriteriaWarningMessage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RegisterPage navigateToRegisterPage() {
		myAccountDropdown.click();
		registerOption.click();
		return new RegisterPage(driver);
	}

	public void clickOnMyAccountDropdown() {
		myAccountDropdown.click();
	}

	public LoginPage clickOnLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}

	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}

	public void enterProductInSearchTextbox(String productText) {
		searchTextbox.sendKeys(productText);
	}

	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}

	public String retrieveNoProductMatchSearchCriteriaWarningMessage() {
		String noProductMatchSearchCriteriaWarningMessage = actualNoProductMatchSearchCriteriaWarningMessage.getText();
		return noProductMatchSearchCriteriaWarningMessage;
	}

	public SearchPage searchProduct(String productName) {
		searchTextbox.sendKeys(productName);
		searchButton.click();
		return new SearchPage(driver);
	}

	public LoginPage navigateToLoginPage() {
		myAccountDropdown.click();
		loginOption.click();
		return new LoginPage(driver);
	}
}