package com.qa.luma.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaAccountSucessPage {
	
	public WebDriver driver;

	// we have define all the objects

	@FindBy(xpath = "//div [text () = 'Thank you for registering with Main Website Store.']")
	private WebElement registationMessage;
	

	@FindBy(xpath = "//span[text()='Thank you for your purchase!']")
	private WebElement thankYouForPurchaseMessage;

	// we initialize the objects by creating constractor
	public LumaAccountSucessPage(WebDriver driver) {
		this.driver = driver;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects

	public boolean verifyingRegistationSucessMessage() {
		boolean result = registationMessage.isDisplayed();
		return result;

	}
	public boolean checkOutThankYouSucessMessageDisplay() {
		boolean result = thankYouForPurchaseMessage.isDisplayed();
		return result;
	}

}


