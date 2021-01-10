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

public class StoryReviewModificationDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the scrum tool add page and set up story with review named \"([^\"]*)\" with review of \"([^\"]*)\"$")
	public void I_open_the_scrum_tool_add_page_and_set_up_story_with_review_named_with_review_of(String storyname,
			String reviewStatus) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
		
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("story-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(storyname);

		WebElement addStory = driver.findElement(By.id("add-story-button"));
		addStory.click();
		
		WebElement reviewButton = driver.findElement(By.id("add-story-review"));
		reviewButton.click();
		
		WebElement reviewTitleTextBox = driver.findElement(By.id("review-status"));
		reviewTitleTextBox.clear();
		reviewTitleTextBox.sendKeys(reviewStatus);
		
		WebElement addReview = driver.findElement(By.id("review-story-button"));
		addReview.click();
		
	}

	@When("^I push update review button navigate to the update review page$")
	public void I_push_update_review_button_navigate_to_the_update_review_page() throws Throwable {
		WebElement updateReview = driver.findElement(By.id("update-story-review"));
		updateReview.click();

	}

	@When("^I navigated to the update form I should see \"([^\"]*)\" in the review status$")
	public void I_navigated_to_the_update_form_I_should_see_in_the_review_status(String reviewStatus) throws Throwable {
		
		WebElement reviewTitleTextBox = driver.findElement(By.id("review-status"));
		String result = reviewTitleTextBox.getAttribute("value");
		Assert.assertEquals(reviewStatus, result);
		
	}

	@When("^I enter \"([^\"]*)\" in the review box and push the update button$")
	public void I_enter_in_the_review_box_and_push_the_update_button(String reviewString) throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("review-status"));
		titleTextBox.clear();
		titleTextBox.sendKeys(reviewString);
		
		WebElement addReview = driver.findElement(By.id("review-story-button"));
		addReview.click();
	}

	@Then("^I should get result \"([^\"]*)\" in the story view after update$")
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
