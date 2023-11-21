package com.qa.luma.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaCheckOutPage {
	public WebDriver driver;

	
	// we have define all the objects
	@FindBy(xpath = "//a[@class='product-item-link'][contains(text(),'Quest Lumaflex™ Band')]")
	private WebElement questProductLink;

	@FindBy(xpath = "//img[@alt='Image']")
	private WebElement productImage;

	@FindBy(xpath = "//button[@id='product-addtocart-button']//span[contains(text(),'Add to Cart')]")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement successMessage;

	@FindBy(xpath = "//a[@class='action showcart']")
	private WebElement shoppingCartLink;

	@FindBy(xpath = "//span[contains(text(),'View and Edit Cart')]")
	private WebElement viewAndEditCartLink;



	@FindBy(css = "input[value='flatrate_flatrate']")
	private WebElement flatRateShippingOption;

	@FindBy(xpath = "//button[@class='button action continue primary']")
	private WebElement continueToPaymentButton;

	@FindBy(xpath = "//button[@title='Place Order']")
	private WebElement placeOrderButton;

	// we initialize the objects by creating constractor
	public LumaCheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects


	public void clickOnProductLink() {
		questProductLink.click();
		
	}

	public boolean isProductImageDisplayed() {
		boolean result = productImage.isDisplayed();
		return result;
		
	}

	public void addToCart() {
		addToCartButton.click();
	}

	public boolean isSuccessMessageDisplayed() {
		return successMessage.isDisplayed();
	}

	public void goToShoppingCart() {
		shoppingCartLink.click();
	}

	public void viewAndEditCart() {
		viewAndEditCartLink.click();
	}

	public void selectFlatRateShipping() {
		flatRateShippingOption.click();
	}

	public void continueToPayment() {
		continueToPaymentButton.click();
	}

	public void clickOnPlaceOrder() {
		placeOrderButton.click();
	}


}
