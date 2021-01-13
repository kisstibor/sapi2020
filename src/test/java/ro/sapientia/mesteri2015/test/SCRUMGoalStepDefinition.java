package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMGoalStepDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the goal creator tool$")
	public void I_open_the_goal_creator_tool_add_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}
	
	@When("^I enter \"([^\"]*)\" in the goal textbox and I push the add goal button$")
	public void I_enter_in_the_goal_textbox_and_I_push_the_add_goal_button(
			String additionTerms) throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-goal-button"));
		addButton.click();

		// Write term in google textbox
		WebElement goalTextBox = driver.findElement(By.id("goal-goal"));
		goalTextBox.clear();
		goalTextBox.sendKeys(additionTerms);

		// Click on searchButton
		WebElement searchButton = driver.findElement(By.id("add-goal-button"));
		searchButton.click();
	}
	
	@Then("^I should get result \"([^\"]*)\" in goals list$")
	public void I_should_get_result_in_goals_list(String expectedResult)
			throws Throwable {
		WebElement calculatorTextBox = driver.findElement(By.id("goal-goal"));
		String result = calculatorTextBox.getText();

		// Verify that result of 2+2 is 4
		Assert.assertEquals(result, expectedResult);

		driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
