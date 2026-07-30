	package com.Step_Definitions;
	
	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	
	import com.Factory.Driver_Factory;
	import com.Pages.DashboardPage;
	import com.Pages.LoginPage;
	
	import io.cucumber.java.en.And;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	
	public class Login {
	
		WebDriver driver;
		private LoginPage loginPage;
		private DashboardPage dashboardPage;
	
		@Given("user navigates to login page")
		public void user_navigates_to_login_page() {
	
			driver = Driver_Factory.getDriver();
			loginPage = new LoginPage(driver);
			Assert.assertTrue(driver.getCurrentUrl().contains("freecrm.com"));
		}
	
		@And("user enters valid email address {string} into email field")
		public void user_enters_valid_email_address_into_email_field(String emailText) {
	
			loginPage.enterEmailAddress(emailText);
	
		}
	
		@And("user enters valid password {string} into password field")
		public void user_enters_valid_password_into_password_field(String password) {
	
			loginPage.enterPassword(password);
	
		}
	
		@When("user click the login button")
		public void user_click_the_login_button() {
	
			dashboardPage = loginPage.clickLogin();
	
		}
	
		@Then("user should get successfully logged in")
		public void user_should_get_successfully_logged_in() {
	
			Assert.assertTrue(dashboardPage.displaySuccessfullLoginMessage());
		}
	
		// Invalid Credentials
	
		@Given("enters valid email address {string} into email field")
		public void enters_valid_email_address_into_email_field(String invalidEmail) {
			
			loginPage.enterEmailAddress(invalidEmail);
	
		}
	
		@Given("enters valid password {string} into password field")
		public void enters_valid_password_into_password_field(String invalidpassword) {
	
			loginPage.enterPassword(invalidpassword);
	
		}
	
		@Then("user should get the proper warning message about credentials mismatch")
		public void user_should_get_the_proper_warning_message_about_credentials_mismatch() {
			
			
			Assert.assertTrue(loginPage.getInvalidCredentialsWarningMessage().contains("Something went wrong..."));
	
		}
	}
