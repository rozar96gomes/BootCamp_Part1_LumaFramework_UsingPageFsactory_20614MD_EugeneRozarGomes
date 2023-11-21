package com.qa.luma.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LunaShoppingCartPage {
	
	    public  WebDriver driver;
	    
	   
	    // we have define all the objects
	    @FindBy(xpath = "//input[@id='search']")
	    private WebElement searchInput;

	    @FindBy(linkText = "Voyage Yoga Bag")
	    private WebElement yogaBagLink;

	    @FindBy(id = "product-addtocart-button")
	    private WebElement addToCartButton;

	    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	    private WebElement successMessage;
	    
		@FindBy(xpath = "//span[contains(text(),'Proceed to Checkout')]")
		private WebElement proceedToCheckoutButton;

	    // we initialize the objects by creating constractor
	    public LunaShoppingCartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // we have take action on those objects
	    public void searchForProduct(String productName) {
	        searchInput.sendKeys(productName);
	        searchInput.sendKeys(Keys.RETURN);
	    }

	    public LunaShoppingCartPage clickOnVoyageYogaBagLink() {
	    	yogaBagLink.click();
	    	return new LunaShoppingCartPage(driver);
	    }

	    public LunaShoppingCartPage addToCart() {
	        addToCartButton.click();
	        return new LunaShoppingCartPage(driver);
	    }
		public void proceedToCheckout() {
			proceedToCheckoutButton.click();
		}

	    public boolean successMessageDisplayeMessage() {
	        boolean result = successMessage.isDisplayed();
	        return result;
	    }
	}



