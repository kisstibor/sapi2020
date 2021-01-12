package ro.sapientia.mesteri2015.test;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMStoryStatusDefinition {

	protected WebDriver driver;
	
	private static long StoryId;
	

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
/////Scenario: CreateAStoryFirst
	@Given("^I will add a new story on the list$")
	public void I_add_a_new_story_on_the_list2() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/add");
	}

	@When("^I will enter \"([^\"]*)\" in the title textbox and \"([^\"]*)\" in the description textbox also I set tomorrow's date as due date then I push the create button$")
	public void I_fill_the_form_and_I_push_the_create_button2(String title,String description) throws Throwable {
		
		WebElement titleField = driver.findElement(By.id("story-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(title);
		
		WebElement descField = driver.findElement(By.id("story-description"));
		descField.sendKeys(Keys.CONTROL + "a");
		descField.sendKeys(Keys.DELETE);
		descField.sendKeys(description);
		
		WebElement dateField = driver.findElement(By.id("story-dueDate"));
		dateField.clear();
		dateField.sendKeys("2021-01-21");
		
		WebElement createStoryButton = driver.findElement(By.id("add-story-button"));
		createStoryButton.click();
	
	}
	
	@Then("^I will get a new story as \"([^\"]*)\" in the list$")
	public void I_should_get_a_new_story2(String expectedResult) throws Throwable {
		WebElement titleText = driver.findElement(By.id("story-title"));
		String result = titleText.getText();
		
		String url = driver.getCurrentUrl();
		Assert.assertEquals(true,url.contains("story/"));
		Assert.assertEquals(result, expectedResult);
		
		StoryId = Integer.parseInt(url.substring(url.length() - 1));
		//driver.close();
	}
	
	//////////////////////////////////////////Scenario: UpdateIt
	
	@Given("^I will access the created story$")
	public void I_access_the_story2() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/"+StoryId);
	}
	
	@Given("^I will press modify button$")
	public void I_press_modify_button() throws Throwable {
		WebElement updateStoryButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[1]/a[1]"));
		updateStoryButton.click();
	}

	@When("^I enter \"([^\"]*)\" in the title textbox I set the status to \"([^\"]*)\" I push the create button$")
	public void I_complete_the_update_form_and_post_it(String title,String status) throws Throwable {
		
		WebElement titleField = driver.findElement(By.id("story-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(title);
		
		WebElement descField = driver.findElement(By.id("story-description"));
		descField.sendKeys(Keys.CONTROL + "a");
		descField.sendKeys(Keys.DELETE);
		descField.sendKeys("test text");
		
		Select statusField = new Select(driver.findElement(By.id("StatusEnum")));
		statusField.selectByVisibleText(status);
		
		WebElement createStoryButton = driver.findElement(By.xpath("//*[@id=\"update-story-button\"]"));
		createStoryButton.click();
	
	}
	
	@Then("^I should get a new story as \"([^\"]*)\" with \"([^\"]*)\" status$")
	public void I_should_see_an_updated_story(String expectedTitle,String expectedStatus) throws Throwable {
		WebElement titleText = driver.findElement(By.id("story-title"));
		String result = titleText.getText();
		
		WebElement statusText = driver.findElement(By.id("story-status"));
		String status = statusText.getText();
		
		Assert.assertEquals(true,driver.getCurrentUrl().contains("story/"));
		Assert.assertEquals(result, expectedTitle);
		Assert.assertEquals("Status: "+expectedStatus, status);
		//driver.close();
	}
	
	@Then("^I should see the time management table$")
	public void I_should_see_the_table() throws Throwable {
		try
		{
		  driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[4]/table"));
		  System.out.println("Page 1 is present");
		}
		catch (NoSuchElementException nsee)
		{
		  System.out.println("Page 2 is present");
		  Assert.fail(nsee.getMessage());
		}
		//driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

	
}
