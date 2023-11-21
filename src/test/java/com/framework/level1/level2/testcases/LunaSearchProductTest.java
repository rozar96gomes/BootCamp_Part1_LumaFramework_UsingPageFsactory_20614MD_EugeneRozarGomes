package com.framework.level1.level2.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.luma.Pages.LunaSearchProductPage;
import com.qa.luma.TestBase.Luma_TestBase;

public class LunaSearchProductTest extends Luma_TestBase {

	public LunaSearchProductTest() throws Exception {
		super();
	
	}

	public WebDriver driver;
	public LunaSearchProductPage searchProductPage;

    @BeforeMethod
    public void lunaSearchProduct() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        searchProductPage = new LunaSearchProductPage(driver);

       
    }

    @Test(priority = 1)
    public void testProductSearchAndNavigation() {
        searchProductPage.searchBoxField(prop.getProperty("validProduct3"));
        Assert.assertTrue(searchProductPage.searchResultsMessageDisplayeMessage());

        searchProductPage.clickOnJadeYogaJacketLink();
        Assert.assertTrue(searchProductPage.JadeYogaJacketDescriptionDisplayeMessage());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
