package ro.sapientia.mesteri2015.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMTaskAddStepDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I create a new story$")
	public void I_open_the_scrum_list_s_first_story() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		// Write term in google textbox
		WebElement titleTextBox = driver.findElement(By.id("story-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys("myStoryWithTask");
		
		//description
		WebElement descTextBox = driver.findElement(By.id("story-description"));
		descTextBox.clear();
		descTextBox.sendKeys("myStoryWithTaskDescription");

		// Click on searchButton
		WebElement searchButton = driver.findElement(By.id("add-story-button"));
		searchButton.click();
	}

	@When("^I enter \"([^\"]*)\" in  the task title textbox and I push the add button$")
	public void I_enter_in_the_task_title_textbox_and_I_push_the_add_button(String taskTitle) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement taskTitleTextBox = driver.findElement(By.id("new_task-title"));
		taskTitleTextBox.clear();
		
		WebElement addTaskButton = driver.findElement(By.id("add-task-button"));
		addTaskButton.click();
	
	}
	
	@Then("^I should get result \"([^\"]*)\" in tasks list$")
	public void I_should_get_result_in_new_stories_list(String expectedResult) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		//WebElement taskTitleText = driver.findElement(By.id("task-title"));
		//String result = taskTitleText.getText();

		//Assert.assertEquals(result, expectedResult);
		//Assert.assertNotSame(result, expectedResult);
		//driver.close();
		WebElement taskList = driver.findElement(By.id("task-list"));
		assertEquals(expectedResult, taskList.getText());
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}

}
