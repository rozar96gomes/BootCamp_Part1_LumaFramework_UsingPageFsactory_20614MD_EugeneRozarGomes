package com.qa.luma.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	// we have define all the objects

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	private WebElement dropDownButton;

	@FindBy(linkText = "My Account")
	private WebElement myAccount;

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	private WebElement clickOnSign;
	

	@FindBy(linkText = "Create an Account")
	private WebElement createAnAccount;

	// we initialize the objects by creating constractor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects

	public HomePage clickOnDropDown() {
		dropDownButton.click();
		return new HomePage(driver);
		
	}
	public LunaCustomerLoginPage clickOnSignInOption() {
		clickOnSign.click();
		return new LunaCustomerLoginPage(driver);
	}

	public boolean verifyingMyAccount() {
		boolean result = myAccount.isDisplayed();
		return result;
	}
	public RegisterPage clickOnCreateAnAccount() {
		createAnAccount.click();
		return new RegisterPage(driver);
	}

}