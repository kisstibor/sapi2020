package ro.sapientia.mesteri2015.test;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

public class SCRUMStoryDueDateDefinition {

	protected WebDriver driver;
	
	private static long StoryId;
	

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I have already an \"([^\"]*)\" story with \"([^\"]*)\" as title$")
	public void I_prepare_the_story(String availability, String title) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/add");
		
		WebElement titleField = driver.findElement(By.id("story-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(title);
		
		WebElement descField = driver.findElement(By.id("story-description"));
		descField.sendKeys(Keys.CONTROL + "a");
		descField.sendKeys(Keys.DELETE);
		descField.sendKeys("test text");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 
		Date date = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		
		WebElement dateField = driver.findElement(By.id("story-dueDate"));
		dateField.clear();
		if(availability.trim().equalsIgnoreCase("available")) {
			c.add(Calendar.DATE, 2);
			dateField.sendKeys(dateFormat.format(c.getTime()));
		}else {
			if(availability.trim().equalsIgnoreCase("expired")) {
				c.add(Calendar.DATE, -2);
				dateField.sendKeys(dateFormat.format(c.getTime()));
			}else {
				throw new Exception("The story status should be either available or exired! but it was: "+availability);
			}
		}
		WebElement createStoryButton = driver.findElement(By.id("add-story-button"));
		createStoryButton.click();
	
		WebElement titleText = driver.findElement(By.id("story-title"));
		String result = titleText.getText();
		
		String url = driver.getCurrentUrl();
		Assert.assertEquals(true,url.contains("story/"));
		Assert.assertEquals(result, title);
		
		StoryId = Integer.parseInt(url.substring(url.length() - 1));
		//driver.close();
	}
	

	@When("^I access the story page for informations$")
	public void I_access_the_created_story() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/"+StoryId);
	
	}
	
	@Then("^I should see the due date in \"([^\"]*)\"$")
	public void I_should_see_an_updated_story(String expectedColor) throws Throwable {
		String dueDateStyleAttribute = driver.findElement(By.id("story-dueDate")).getAttribute("style");
		if(dueDateStyleAttribute.contains("color: "+expectedColor)) {
			return;
		}else {
			Assert.fail("DuedDate color mismatch expected: "+expectedColor+" got: "+dueDateStyleAttribute);
		}
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

	
}
