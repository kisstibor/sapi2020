package ro.sapientia.mesteri2015.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMAddCommentDefinition {

	protected WebDriver driver;
	
	private static long StoryId;
	
	private static boolean onceFlag=false;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	///
	
	@Given("^A Story is already created as \"([^\"]*)\"$")
	public void I_assure_that_there_is_a_story(String title) throws Throwable {
		if(onceFlag)
			return;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		driver.get("http://localhost:8080/");
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
		
		WebElement titleField = driver.findElement(By.id("story-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(title);
		
		WebElement descField = driver.findElement(By.id("story-description"));
		descField.sendKeys(Keys.CONTROL + "a");
		descField.sendKeys(Keys.DELETE);
		descField.sendKeys("blabla");
		
		WebElement dateField = driver.findElement(By.id("story-dueDate"));
		dateField.clear();
		dateField.sendKeys("2021-01-21");
		
		WebElement createStoryButton = driver.findElement(By.id("add-story-button"));
		createStoryButton.click();
		
		WebElement titleElement = driver.findElement(By.id("story-title")); 
		String result = titleElement.getText();
		
		String url = driver.getCurrentUrl();
		Assert.assertEquals(true,url.contains("story/"));
		Assert.assertEquals(result, title);
		
		onceFlag = true;
		StoryId = Integer.parseInt(url.substring(url.length() - 1));
		//driver.close();
	}
	
	/////////////
	
	
	@Given("^I open the first story in the list$")
	public void I_open_the_story_list() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		driver.get("http://localhost:8080/story/"+StoryId);
	}
	
	@Given("^I click on add comment button$")
	public void I_open_the_story_page() throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-comment-button"));
		addButton.click();
	}

	@When("^I enter \"([^\"]*)\" in the message textbox and I push the add button$")
	public void I_enter_comment_and_press_add(String message) throws Throwable {
		
		WebElement messageTextBox = driver.findElement(By.id("story-description"));
		messageTextBox.clear();
		messageTextBox.sendKeys(message);

		WebElement addCommentButton = driver.findElement(By.id("add-story-button"));
		addCommentButton.click();
	}

	@Then("^I should see the \"([^\"]*)\" comment under the \"([^\"]*)\" story$")
	public void I_should_see_the_comment(String commentText,String storyTitle)	throws Throwable {
		WebElement commentParagraph = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[3]/div[1]/p[1]")); // /html/body/div/div[2]/div[2]/div[2]/div[3]/div[1]/p[1]
		String result = commentParagraph.getText();

		WebElement storyTitleHeader = driver.findElement(By.id("story-title"));
		String title = storyTitleHeader.getText();
		
		Assert.assertEquals(result, commentText);
		Assert.assertEquals(title, storyTitle);

		//driver.close();
	}
	
	
	///////////////////////
	
	
	@Given("^I am on a story page already$")
	public void I_am_on_a_story_page_already() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/"+StoryId);
	}
	
	@Given("^I pressed the comment modify button$")
	public void I_edit_the_scrum_list_s_first_story() throws Throwable {
		WebElement modifyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[3]/div[1]/a[1]"));
		modifyButton.click();
	}

	@When("^I enter \"([^\"]*)\" in the message textbox and I push the update button$")
	public void I_enter_in_the_title_textbox_and_I_push_the_update_button(String updatedMessage) throws Throwable {
	    
		WebElement messageField = driver.findElement(By.id("story-description"));
		messageField.sendKeys(Keys.CONTROL + "a");
		messageField.sendKeys(Keys.DELETE);
		messageField.sendKeys(updatedMessage);
		
		WebElement updateStoryButton = driver.findElement(By.xpath("//*[@id=\"update-story-button\"]"));
		updateStoryButton.click();
	
	}
	
	@Then("^I should see the changed comment \"([^\"]*)\"$")
	public void I_should_get_result_in_new_stories_list(String expectedResult) throws Throwable {
	    
		WebElement messageText = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[3]/div[1]/p[1]"));
		String result = messageText.getText();

		
		Assert.assertEquals(result, expectedResult);
		
		//driver.close();
	}
	
	///////////////////////////////////////////
	
	@When("^I pressed the comment delete button$")
	public void I_press_the_delete_button() throws Throwable {
	    
		WebElement deleteButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[3]/div[1]/a[2]"));
		deleteButton.click();
	
	}
	
	@Then("^The comment is gone$")
	public void Comment_is_gone() throws Throwable {
	    
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'No entries found.')]"));

		
		Assert.assertEquals(list.size(), 1);
		
		//driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
