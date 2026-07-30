package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Common_Utils;
import com.Utilities.Element_Utils;

public class LoginPage {

	WebDriver driver;
	private Element_Utils element_Utils;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		element_Utils = new Element_Utils(driver);
	}

	@FindBy(name = "email")
	private WebElement EmailInputField;

	@FindBy(name = "password")
	private WebElement PasswordInputField;

	@FindBy(xpath = "//div[text()=\"Login\"]")
	private WebElement Login_Button;

	@FindBy(xpath = "//div[@class=\"ui negative message\"]")
	private WebElement InvalidCredentialsWarningMessage;

	public void enterEmailAddress(String emailText) {

		element_Utils.sendTextToInputField(EmailInputField, emailText, Common_Utils.EXPLICIT_WAIT_TIME);

	}

	public void enterPassword(String password) {

		element_Utils.sendTextToInputField(PasswordInputField, password, Common_Utils.EXPLICIT_WAIT_TIME);

	}

	public DashboardPage clickLogin() {

		element_Utils.clickOnElement(Login_Button, Common_Utils.EXPLICIT_WAIT_TIME);
		return new DashboardPage(driver);
	}

	public String getInvalidCredentialsWarningMessage() {

		return InvalidCredentialsWarningMessage.getText();
	}

}
