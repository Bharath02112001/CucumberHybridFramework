package com.Hooks;

import java.io.File;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Factory.Driver_Factory;
import com.Utilities.Config_Reader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class My_Hooks {

	WebDriver driver;
	private Config_Reader configReader;

	@Before
	public void setUp() {

		Properties prop = new Config_Reader().initializenProperties();
		driver = Driver_Factory.initialzationBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("qaurl"));
	}

	@After
	public void tearDown(Scenario scenario) {

		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
			
			byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", scenarioName);
			
		}
		driver.quit();

	}
}
