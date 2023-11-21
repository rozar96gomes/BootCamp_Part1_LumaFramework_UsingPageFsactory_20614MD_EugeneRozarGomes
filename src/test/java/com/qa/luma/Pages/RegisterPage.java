package com.qa.luma.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;
	// we have define all the objects


	@FindBy(xpath = "//span[text() = 'Create New Customer Account']")
	private WebElement createNewCustomerAccount;

	@FindBy(id = "firstname")
	private WebElement firstNameTextBox;

	@FindBy(id = "lastname")
	private WebElement lastNameTextBox;

	@FindBy(id = "email_address")
	private WebElement emailTextBox;

	@FindBy(id = "input-password")
	private WebElement passwordTextBox;

	@FindBy(id = "password")
	private WebElement PasswordTextBox;

	@FindBy(id = "password-confirmation")
	private WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	private WebElement createAnAccountButton;


	// we initialize the objects by creating constractor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects



	public boolean verifyingCreateNewCustomerAccountMessage() {
		boolean result = createNewCustomerAccount.isDisplayed();
		return result;
	}

	public void enterFirstName(String firstNameText) {
		firstNameTextBox.sendKeys(firstNameText);

	}

	public void enterLastName(String lastNameText) {
		lastNameTextBox.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}

	public void enterPassword(String passwordText) {
		PasswordTextBox.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
	}

	public RegisterPage clickOnCreateAccount() {
		createAnAccountButton.click();
		return new RegisterPage(driver);

	}


}
