package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StoryReviewDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the scrum tool add page and add a new story with name \"([^\"]*)\"$")
	public void I_open_the_scrum_tool_add_page_and_add_a_new_story_with_name(String storyTitle) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
		
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("story-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(storyTitle);

		WebElement addStory = driver.findElement(By.id("add-story-button"));
		addStory.click();
		
		
	}

	@When("^I push review button navigate to the review page$")
	public void I_push_review_button_navigate_to_the_review_page() throws Throwable {
		WebElement reviewButton = driver.findElement(By.id("add-story-review"));
		reviewButton.click();
			    
	}

	@When("^I enter \"([^\"]*)\" in the review box and push tre review button$")
	public void I_enter_in_the_review_box_and_push_tre_review_button(String reviewString) throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("review-status"));
		titleTextBox.clear();
		titleTextBox.sendKeys(reviewString);
		
		WebElement addReview = driver.findElement(By.id("review-story-button"));
		addReview.click();
	}

	@Then("^I should get result \"([^\"]*)\" in the story view$")
	public void I_should_get_result_in_the_story_view(String reviewStatus) throws Throwable {

		WebElement reviewStatusField = driver.findElement(By.id("review-status"));
		String result = reviewStatusField.getText();

		Assert.assertEquals(result, reviewStatus);
		//driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
