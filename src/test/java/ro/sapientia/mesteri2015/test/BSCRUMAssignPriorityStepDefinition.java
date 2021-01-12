package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BSCRUMAssignPriorityStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the scrum tool priority assign page$")
	public void I_open_the_scrum_tool_priority_add_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/add");
	}

	@When("^I enter \"([^\"]*)\" in  the title textbox select \"([^\"]*)\" and I push the add button$")
	public void I_enter_in_the_title_textbox_select_priority_and_I_push_the_add_button(
			String additionTerms, String priority) throws Throwable {
		//WebElement addButton = driver.findElement(By.id("add-button"));
		//addButton.click();

		// Write term in google textbox
		WebElement titleTextBox = driver.findElement(By.id("story-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(additionTerms);
		
		Select prioritySelect = new Select( driver.findElement(By.id( "story-priority" )) );
		prioritySelect.selectByVisibleText( priority );

		// Click on searchButton
		WebElement searchButton = driver.findElement(By.id("add-story-button"));
		searchButton.click();
	}

	@Then("^I should get result \"([^\"]*)\" in story detail page$")
	public void I_should_get_result_in_story_detail_page(String expectedResult)
			throws Throwable {
		WebElement calculatorTextBox = driver.findElement(By.id("priority-name"));
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
