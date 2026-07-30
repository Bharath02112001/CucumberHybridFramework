package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.Element_Utils;

public class DashboardPage {

	WebDriver driver;
	private Element_Utils element_Utils;

	public DashboardPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		element_Utils = new Element_Utils(driver);
	}

	@FindBy(xpath = "//div[@class=\"header item\"]")
	private WebElement successLoginMessage;

	public boolean displaySuccessfullLoginMessage() {
			
		return element_Utils.displayStatusOfElement(successLoginMessage, 15);

	}
}
