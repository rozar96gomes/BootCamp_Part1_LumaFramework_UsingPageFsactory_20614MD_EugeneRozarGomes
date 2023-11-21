package com.framework.level1.level2.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.luma.Pages.LunaCustomerLoginPage;
import com.qa.luma.Pages.HomePage;
import com.qa.luma.TestBase.Luma_TestBase;

public class LoginTest extends Luma_TestBase {

    public LoginTest() throws Exception {
        super();
    }

    public  WebDriver driver;
    public HomePage homepage;
    public LunaCustomerLoginPage customerloginpage;

    @BeforeMethod
    public void loginSetup() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        homepage = new HomePage(driver);
    
    }

    @Test(priority = 1)
    public void verifyingSuccessfulLoginWithValidCredentials() {
    	customerloginpage = new LunaCustomerLoginPage(driver);
        homepage.clickOnSignInOption();
        customerloginpage.enterValidEmail(prop.getProperty("validEmail"));
        customerloginpage.enterValidPassword(prop.getProperty("validPassword"));
        customerloginpage.clickOnSignInButton();
        homepage.clickOnDropDown();
        Assert.assertTrue(homepage.verifyingMyAccount());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
