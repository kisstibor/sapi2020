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

public class StoryReviewDeleteDefinition {
	
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I have story with name \"([^\"]*)\" and a review.$")
	public void I_have_story_with_name_and_a_review(String storyname) throws Throwable {
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
		reviewTitleTextBox.sendKeys("Approved");
		
		WebElement addReview = driver.findElement(By.id("review-story-button"));
		addReview.click();
	}

	@When("^I push update review button navigate to the update review page where I can delete$")
	public void I_push_update_review_button_navigate_to_the_update_review_page() throws Throwable {
		WebElement updateReview = driver.findElement(By.id("update-story-review"));
		updateReview.click();
	}
	
	@When("^I push the delete review button.$")
	public void I_push_the_delete_review_button() throws Throwable {
		WebElement addButton = driver.findElement(By.id("delete-story-review"));
		addButton.click();
	}

	@Then("^I should not see review in the story view page$")
	public void I_should_not_see_review_in_the_story_view_page() throws Throwable {
		
		try
		{
			WebElement calculatorTextBox = driver.findElement(By.id("review-status"));
			String result = calculatorTextBox.getText();
			Assert.assertNull(result);
		}catch (Exception ex){
			
		}
		
		
		//driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
