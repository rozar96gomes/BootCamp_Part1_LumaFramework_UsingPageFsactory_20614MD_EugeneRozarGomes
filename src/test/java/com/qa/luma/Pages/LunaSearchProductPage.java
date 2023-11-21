package com.qa.luma.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LunaSearchProductPage {

	public WebDriver driver;

	// we have define all the objects
	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchBox;

	@FindBy(xpath = "//span[contains(text(),\"Search results for: 'Jackets'\")]")
	private WebElement searchResultsMessage;

	@FindBy(linkText = "Jade Yoga Jacket")
	private WebElement jackatLink;

	@FindBy(xpath = "//body[1]/div[2]/main[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/p[2]")
	private WebElement jackatDiscriptionLink;

	// we initialize the objects by creating constractor
	public LunaSearchProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects
	public void searchBoxField(String productName) {
		searchBox.sendKeys(productName);
		searchBox.sendKeys(Keys.RETURN);
	}

	public boolean searchResultsMessageDisplayeMessage() {
		boolean result = searchResultsMessage.isDisplayed();
		return result;
	}

	public LunaSearchProductPage clickOnJadeYogaJacketLink() {
		jackatLink.click();
		return new LunaSearchProductPage(driver);
	}

	public boolean JadeYogaJacketDescriptionDisplayeMessage() {
		boolean result = jackatDiscriptionLink.isDisplayed();
		return result;
	}
}
