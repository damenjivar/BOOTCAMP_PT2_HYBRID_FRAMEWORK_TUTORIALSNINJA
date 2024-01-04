package com.tutorialsninja.qa.Pages.pt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidProductPage {

	public WebDriver driver;

	@FindBy(xpath = "//li[contains(text(), 'Product Code:Product 21')]")
	private WebElement actualProductDescriptionDisplayStatus;

	@FindBy(xpath = "//button[@id = 'button-cart']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement actualAddedToCartSuccessMessage;

	@FindBy(css = "button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")
	private WebElement shoppingCartButton;

	@FindBy(linkText = "Checkout")
	private WebElement checkoutLink;

	public ValidProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyProductDescriptionDisplayStatus() {
		boolean presenceOfProductDescription = actualProductDescriptionDisplayStatus.isDisplayed();
		return presenceOfProductDescription;
	}

	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

	public String retrieveAddedToCartSuccessMessage() {
		String addedToCartSuccessMessage = actualAddedToCartSuccessMessage.getText();
		return addedToCartSuccessMessage;
	}

	public void clickOnShoppingCartButton() {
		shoppingCartButton.click();
	}

	public CheckoutPage clickOnCheckoutLink() {
		checkoutLink.click();
		return new CheckoutPage(driver);
	}
}