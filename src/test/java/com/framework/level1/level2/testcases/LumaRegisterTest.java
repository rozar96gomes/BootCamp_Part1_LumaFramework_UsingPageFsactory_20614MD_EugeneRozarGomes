package com.framework.level1.level2.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.luma.Pages.HomePage;
import com.qa.luma.Pages.LumaAccountSucessPage;
import com.qa.luma.Pages.RegisterPage;
import com.qa.luma.TestBase.Luma_TestBase;
import com.qa.luma.Utilities.DateTimeStamp;

public class LumaRegisterTest extends Luma_TestBase {
	
	//Write a TestNG test to verify successful registration with valid credentials.

	public LumaRegisterTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	public DateTimeStamp datetimestamp;
	public RegisterPage registerpage;
	public HomePage homepage;
	public LumaAccountSucessPage registeraccountsucesspage;

	@BeforeMethod
	public void registerSetUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		registerpage = new RegisterPage(driver);
		registeraccountsucesspage = new LumaAccountSucessPage(driver);
	}

	@Test(priority = 1)
	public void verifyRegisterAccountManadatoryFields() throws Exception {
		registerpage = homepage.clickOnCreateAnAccount();
		registerpage.verifyingCreateNewCustomerAccountMessage();
		registerpage.enterFirstName(prop.getProperty("validFirstName"));
		registerpage.enterLastName(prop.getProperty("validLastName"));
	
		registerpage.enterEmail(DateTimeStamp.genaratEmailWithDateTimeStamp());
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
	
		registerpage.clickOnCreateAccount();
		registeraccountsucesspage.verifyingRegistationSucessMessage();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
