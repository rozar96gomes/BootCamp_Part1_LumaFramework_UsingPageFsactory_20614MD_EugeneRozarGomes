package com.qa.luma.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LunaVerifyHomePage {
	
	    public  WebDriver driver;

	 // we have define all the objects
	    @FindBy(linkText = "Sign In")
	    private WebElement signInLink;

	    @FindBy(xpath = "//div[@id='store.menu']")
	    private List<WebElement> listElements;

	    @FindBy(xpath = "//span[contains(text(),'Sale')]")
	    private WebElement saleLink;

	    // we initialize the objects by creating constractor
	    public LunaVerifyHomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	     // we have take action on those objects
	    public boolean signInLinkDisplayMessage() {
	        return signInLink.isDisplayed();
	    }

	    public List<WebElement> getListElements() {
	        return listElements;
	    }

	    public void clickOnSaleLink() {
	        saleLink.click();
	    }
	}



