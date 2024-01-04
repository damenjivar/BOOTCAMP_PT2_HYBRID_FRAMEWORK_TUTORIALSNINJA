package com.tutorialsninja.qa.Pages.pt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[contains(text(), 'HP LP3065')]")
	private WebElement actualValidProductDisplayStatus;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProductLink;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyActualValidProductIsDisplayed() {
		boolean presenceOfValidProduct = actualValidProductDisplayStatus.isDisplayed();
		return presenceOfValidProduct;
	}
	
	public ValidProductPage clickOnValidProductLink() {
		validProductLink.click();
		return new ValidProductPage(driver);
	}
}