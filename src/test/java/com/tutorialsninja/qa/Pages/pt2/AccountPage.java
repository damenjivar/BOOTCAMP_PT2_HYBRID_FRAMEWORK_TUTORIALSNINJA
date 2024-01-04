package com.tutorialsninja.qa.Pages.pt2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[contains(text(), 'Edit your account information')]")
	private WebElement editYourAccountInfoLink;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyDisplayStatusOfEditYourAccountInfoLink() {
		boolean presenceOfEditYourAccountInfoLink = editYourAccountInfoLink.isDisplayed();
		return presenceOfEditYourAccountInfoLink;
	}
}