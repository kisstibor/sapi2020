package ro.sapientia.mesteri2015.test;

import java.util.List;
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

public class SCRUMCommentStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_press_button(String buttonId) throws Throwable {
		WebElement button = driver.findElement(By.id(buttonId));
		button.click();
	}

	@When("^I enter \"([^\"]*)\" in  the \"([^\"]*)\" textbox$")
	public void i_enter_in_the_textbox(String inputText, String textBoxId) throws Throwable {
		WebElement textBox = driver.findElement(By.id(textBoxId));
		textBox.clear();
		textBox.sendKeys(inputText);
	}

	@Then("^I should see (\\d+)x \"([^\"]*)\" in the story's comment list$")
	public void i_should_see_x_in_the_story_s_comment_list(int expectedCount, String commentMessage) throws Throwable {
		List<WebElement> comments = driver
				.findElements(By.xpath("//p[@class='comment-message' and normalize-space()='" + commentMessage + "']"));
		Assert.assertEquals(expectedCount, comments.size());
	}

	@Then("^I should see an error$")
	public void i_should_see_an_error() throws Throwable {
		WebElement error = driver.findElement(By.id("error-title"));
	}

	@When("^I delete the comment with \"([^\"]*)\" message$")
	public void i_delete_the_comment_with_message(String commentMessage) throws Throwable {
		WebElement deleteButton = driver.findElement(By.xpath("//p[@class='comment-message' and normalize-space()='"
				+ commentMessage + "']//following::a[@id='delete-comment-link']"));
		deleteButton.click();

		WebElement confirmationDeleteButton = driver.findElement(By.id("delete-comment-button"));
		confirmationDeleteButton.click();
	}

	@Then("^I see that comments sections states \"([^\"]*)\"$")
	public void i_see_that_comments_sections_states(String expectedEmptyMessage) throws Throwable {
		WebElement emptyMessage = driver
				.findElement(By.xpath("//div[@id='comment-list']/p[normalize-space()='There are no comments yet.']"));
		Assert.assertNotNull(emptyMessage);
	}

	@Then("^comment list contains (\\d+)x comments$")
	public void comment_list_contains_x_comments(int expectedCount) throws Throwable {
		List<WebElement> comments = driver
				.findElements(By.xpath("//div[@id='comment-list']/div[contains(@class, 'comment-item')]"));
		Assert.assertEquals(expectedCount, comments.size());
	}

	@Given("^I am on the view page of a new story called \"([^\"]*)\" with (\\d+)x comment$")
	public void i_am_on_the_view_page_of_a_new_story_called_with_x_comment(String storyName, int nrOfComments)
			throws Throwable {
		driver.get("http://localhost:8080/");

		WebElement addLink = driver.findElement(By.id("add-button"));
		addLink.click();

		WebElement titleTextBox = driver.findElement(By.id("story-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(storyName);

		WebElement addButton = driver.findElement(By.id("add-story-button"));
		addButton.click();

		for (int i = 1; i <= nrOfComments; i++) {
			WebElement addCommentLink = driver.findElement(By.id("add-button"));
			addCommentLink.click();

			WebElement commentTextBox = driver.findElement(By.id("comment-message"));
			commentTextBox.clear();
			commentTextBox.sendKeys(storyName + "Comment " + i);

			WebElement addCommentButton = driver.findElement(By.id("add-comment-button"));
			addCommentButton.click();
		}
	}

	@Then("^I should see \"([^\"]*)\" story's view page$")
	public void i_should_see_story_s_view_page(String storyName) throws Throwable {
		WebElement titleText = driver.findElement(By.id("story-title"));
		String result = titleText.getText();

		Assert.assertEquals(result, storyName);
	}
}
