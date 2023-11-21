package com.framework.level1.level2.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.luma.Pages.LunaShoppingCartPage;
import com.qa.luma.TestBase.Luma_TestBase;

public class ShoppingCartTest extends Luma_TestBase {

	public ShoppingCartTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public LunaShoppingCartPage shoppingCartPage;

	@BeforeMethod
	public void shoppingCartSetUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		shoppingCartPage = new LunaShoppingCartPage(driver);

	}

	@Test(priority =1)
	public void shoppingCartTest() {
		shoppingCartPage.searchForProduct(prop.getProperty("validProduct2"));
		shoppingCartPage.clickOnVoyageYogaBagLink();
		shoppingCartPage.addToCart();

		Assert.assertTrue(shoppingCartPage.successMessageDisplayeMessage());
	}

	@AfterMethod
	public void closer() {
		driver.quit();
	}
}
