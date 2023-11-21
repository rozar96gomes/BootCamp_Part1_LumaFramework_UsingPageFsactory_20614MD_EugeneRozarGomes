package com.framework.level1.level2.testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.luma.Pages.LunaVerifyHomePage;
import com.qa.luma.TestBase.Luma_TestBase;

public class LumaVerifyHomePageTest extends Luma_TestBase {

	// TestNG test to navigate to the home page, verify the presence of certain
	// elements, and click on a link to navigate to a different page.
	
	public LumaVerifyHomePageTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LunaVerifyHomePage lunaverifypage;
	
	@BeforeMethod
	public void loginSetup() throws Exception {
	driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	lunaverifypage = new LunaVerifyHomePage(driver);	
	}

	@Test(priority = 1)
	public void verifyCertainElemetnsOnTheHomePage() throws Exception {
		
		Assert.assertTrue(lunaverifypage.signInLinkDisplayMessage());
		
		List<WebElement> elements = lunaverifypage.getListElements();
		for (WebElement element : elements) {
            System.out.println(element.getText());
		}
	
		lunaverifypage.clickOnSaleLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
