package com.Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.Utilities.Common_Utils;

public class Driver_Factory {

	static WebDriver driver;

	public static WebDriver initialzationBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("Safari")) {

			driver = new SafariDriver();

		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Common_Utils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Common_Utils.IMPLICIT_WAIT_TIME));
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}
