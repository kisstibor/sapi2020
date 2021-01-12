package ro.sapientia.mesteri2015.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMAddUserWithTooLongUsernameStepDefinition {
	
	@Before
	public void setup() {
		WebDriverHelper.openBrowser();
	}
	
	@Given("^I open the add user page$")
	public void I_open_the_add_user_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		WebDriverHelper.get("http://localhost:8080/");
		
		WebElement addUserButton = WebDriverHelper.findElement(By.id("add-user-main-button"));
		addUserButton.click();
	}

	@When("^I enter long username \"([^\"]*)\" in the username textbox, \"([^\"]*)\" in the password textbox and I push the add button$")
	public void I_enter_long_username_in_textbox_in_the_password_textbox_and_I_push_the_add_button(String username, String password) throws Throwable {
		WebElement usernameTextBox = WebDriverHelper.findElement(By.id("user-username"));
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
		
		WebElement passwordTextBox = WebDriverHelper.findElement(By.id("user-password"));
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);

		WebElement addButton = WebDriverHelper.findElement(By.id("add-user-button"));
		addButton.click();
	}

	@Then("^I should get error result for username saying: \"([^\"]*)\"$")
	public void I_should_get_error_result_for_username(String expectedError) throws Throwable {
		WebElement error = WebDriverHelper.findElement(By.id("error-username"));
		String errorMessage = error.getText();
		
		Assert.assertEquals(expectedError, errorMessage);
	}

	@After
	public void closeBrowser() {
		WebDriverHelper.closeBrowser();
	}

}
