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

public class SCRUMAddUserStepDefinition {
	
	@Before
	public void setup() {
		WebDriverHelper.openBrowser();
	}

	@Given("^I open the scrum tool add user page$")
	public void I_open_the_scrum_tool_add_user_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		WebDriverHelper.get("http://localhost:8080/");
		
		WebElement addUserButton = WebDriverHelper.findElement(By.id("add-user-main-button"));
		addUserButton.click();
	}

	@When("^I enter \"([^\"]*)\" in the username textbox, \"([^\"]*)\" in the password textbox and I push the add button$")
	public void I_enter_in_the_username_textbox_in_the_password_textbox_and_I_push_the_add_button(
			String username, String password) throws Throwable {
		WebElement usernameTextBox = WebDriverHelper.findElement(By.id("user-username"));
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
		
		WebElement passwordTextBox = WebDriverHelper.findElement(By.id("user-password"));
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);

		WebElement addButton = WebDriverHelper.findElement(By.id("add-user-button"));
		addButton.click();
	}

	@Then("^I should get result \"([^\"]*)\" in assign to combo box on add story page$")
	public void I_should_get_result_in_assign_to_combobox_on_add_story_page(String expectedUsername)
			throws Throwable {
		WebElement addStoryButton = WebDriverHelper.findElement(By.id("add-button"));
		addStoryButton.click();
		
		WebElement storyUserElement = WebDriverHelper.findElement(By.id("story-user"));
		Select userSelectElement = new Select(storyUserElement);
		List<WebElement> options = userSelectElement.getOptions();
		
		Assert.assertEquals(2, options.size());
		Assert.assertEquals(expectedUsername, options.get(1).getText());
	}

	@After
	public void closeBrowser() {
		WebDriverHelper.closeBrowser();
	}
}
