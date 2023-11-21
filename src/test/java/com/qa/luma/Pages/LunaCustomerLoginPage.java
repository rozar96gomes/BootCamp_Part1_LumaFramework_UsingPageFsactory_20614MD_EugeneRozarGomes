package com.qa.luma.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LunaCustomerLoginPage {

	public WebDriver driver;

	// we have define all the objects
	@FindBy(id = "email")
	private WebElement enterValidEmail;

	@FindBy(id = "pass")
	private WebElement enterValidPassword;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	private WebElement signInButton;

	// we initialize the objects by creating constractor
	public LunaCustomerLoginPage(WebDriver driver) {
		this.driver = driver;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects
	public void enterValidEmail(String userNameText) {
		enterValidEmail.sendKeys(userNameText);
	}

	public void enterValidPassword(String userPassworText) {
		enterValidPassword.sendKeys(userPassworText);
	}

	public LunaCustomerLoginPage clickOnSignInButton() {
		signInButton.click();
		return new LunaCustomerLoginPage(driver);

	}

}
