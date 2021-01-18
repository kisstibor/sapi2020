package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMStoryCreateStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I add a new story to the list$")
	public void I_add_a_new_story_to_the_list() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I enter \"([^\"]*)\" in  the title textbox and \\\"([^\\\"]*)\\\" in the description textbox and I push the add button$")
	public void I_enter_in_the_title_textbox_and_in_the_description_textbox_and_I_push_the_add_button(String updateTitle, String updateDescription) throws Throwable {
	
		//driver.wait(1000);
		WebElement titleField = driver.findElement(By.id("story-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(updateTitle);
		
		WebElement descriptionField = driver.findElement(By.id("story-description"));
		descriptionField.sendKeys(Keys.CONTROL + "a");
		descriptionField.sendKeys(Keys.DELETE);
		descriptionField.sendKeys(updateDescription);
		
		WebElement addStoryButton = driver.findElement(By.id("add-story-button"));
		addStoryButton.click();
	
	}
	
	@Then("^I should get a new story as \"([^\"]*)\" in the stories list$")
	public void I_should_get_a_new_story_as_in_the_stories_list(String expectedResult) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement titleText = driver.findElement(By.id("story-title"));
		String result = titleText.getText();

		// Verify that result of 2+2 is 4
		Assert.assertEquals(result, expectedResult);
		//Assert.assertNotSame(result, expectedResult);
		driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
