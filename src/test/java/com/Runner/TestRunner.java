package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com.features", glue = { "com.Step_Definitions",
		"com.Hooks" }, plugin = { "pretty", "summary", "html:target/CucumberReports/CucumberReport.html" }, publish = true)
public class TestRunner {

}
