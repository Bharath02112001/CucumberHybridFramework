package com.Utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element_Utils {

	WebDriver driver;

	public Element_Utils(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement waitForElement(WebElement element, long durationOfSecond) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSecond));
			WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;

	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationOfSecond) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSecond));
			WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;

	}

	public Alert waitForAlert(long durationOfSecond) {

		Alert alert = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSecond));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void clickOnElement(WebElement element, long durationOfSecond) {

		WebElement webElement = waitForElement(element, durationOfSecond);
		webElement.click();
	}

	public void sendTextToInputField(WebElement element, String inputText, long durationOfSecond) {

		WebElement webElement = waitForElement(element, durationOfSecond);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(inputText);

	}

	public void acceptTheAlert(WebElement element, long durationOfSecond) {

		Alert alert = waitForAlert(durationOfSecond);
		alert.accept();
	}

	public String getTextFromElement(WebElement element, long durationOfSecond) {

		WebElement webElement = waitForElement(element, durationOfSecond);
		return webElement.getText();
	}

	public boolean displayStatusOfElement(WebElement element, long durationOfSecond) {

		try {
			WebElement webElement = waitForVisibilityOfElement(element, durationOfSecond);
			return webElement.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
