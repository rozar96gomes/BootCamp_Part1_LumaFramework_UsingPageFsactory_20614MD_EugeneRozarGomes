package com.framework.level1.level2.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.luma.Pages.HomePage;
import com.qa.luma.Pages.LumaAccountSucessPage;
import com.qa.luma.Pages.LumaCheckOutPage;
import com.qa.luma.Pages.LunaCustomerLoginPage;
import com.qa.luma.Pages.LunaSearchProductPage;
import com.qa.luma.Pages.LunaShoppingCartPage;
import com.qa.luma.TestBase.Luma_TestBase;

public class LumaCheckOutTest extends Luma_TestBase {

	public LumaCheckOutTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LumaCheckOutPage lumacheckoutpage;
	public LunaCustomerLoginPage customerloginpage;
	public HomePage homepage;
	public LunaSearchProductPage lunasearchproductpage;
	public LumaAccountSucessPage lumaaccountsucesspage;
	public LunaShoppingCartPage lumashoppingcartpage;
	

	@BeforeMethod
	public void checkoutSetUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		
		lumacheckoutpage  = new LumaCheckOutPage(driver);
		customerloginpage = new LunaCustomerLoginPage(driver);
	    		homepage  = new HomePage(driver);
	lunasearchproductpage = new LunaSearchProductPage(driver);
	lumaaccountsucesspage = new LumaAccountSucessPage(driver);
	lumashoppingcartpage = new LunaShoppingCartPage(driver);
	
	}

	@Test(priority = 1)
	public void verifyAddAProductToTheShoppingCartAndNavigateToCheckOutPage() throws InterruptedException {
		
		homepage.clickOnSignInOption();
		customerloginpage.enterValidEmail(prop.getProperty("validEmail"));
		customerloginpage.enterValidPassword(prop.getProperty("validPassword"));
		customerloginpage.clickOnSignInButton();

		lunasearchproductpage.searchBoxField(prop.getProperty("validProduct1"));
		lumacheckoutpage.clickOnProductLink();

		Assert.assertTrue(lumacheckoutpage.isProductImageDisplayed(), "Product image not displayed.");

		lumacheckoutpage.addToCart();
		Assert.assertTrue(lumacheckoutpage.isSuccessMessageDisplayed(), "Add to cart success message not displayed.");

		lumacheckoutpage.goToShoppingCart();
		lumacheckoutpage.viewAndEditCart();
		Thread.sleep(2000);
		lumashoppingcartpage.proceedToCheckout();
		lumacheckoutpage.selectFlatRateShipping();

		lumacheckoutpage.continueToPayment();
		Thread.sleep(2000);
		lumacheckoutpage.clickOnPlaceOrder();

		Assert.assertTrue(lumaaccountsucesspage.checkOutThankYouSucessMessageDisplay(), "Thank you message not displayed.");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
