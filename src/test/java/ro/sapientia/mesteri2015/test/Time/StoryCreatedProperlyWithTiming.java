package ro.sapientia.mesteri2015.test.Time;

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
import net.bytebuddy.implementation.EqualsMethod;

public class StoryCreatedProperlyWithTiming {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the base webpage and navigate to the adding story page$")
	public void I_open_the_base_webpage_and_navigate_to_the_adding_story_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/add");
	}

	@When("^I fill all data with predefined values and push the add story button to register the story$")
	public void I_fill_all_data_with_predefined_values_and_push_the_add_story_button_to_register_the_story() throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// find textbox and inputs
		WebElement titleInput = driver.findElement(By.id("story-title"));
		WebElement descriptionTextbox = driver.findElement(By.id("story-description"));
		WebElement timeInput = driver.findElement(By.id("story-time"));
		
		// clear textbox and inputs
		titleInput.clear();
		descriptionTextbox.clear();
		timeInput.clear();
		
		// fill textbox and inputs with values
		titleInput.sendKeys("Cat");
		descriptionTextbox.sendKeys("Dog");
		timeInput.sendKeys("4");
		
		// find the add button and pushing it
		WebElement addButton = driver.findElement(By.id("add-story-button"));
		addButton.click();
	}

	@Then("^I check on the page that the story created properly$")
	public void I_check_on_the_page_that_the_story_created_properly()
			throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		WebElement title = driver.findElement(By.id("story-title"));
		WebElement description = driver.findElement(By.id("story-description"));
		WebElement time = driver.findElement(By.id("story-time"));

		Assert.assertEquals(title.getText(), "Cat");
		Assert.assertEquals(description.getText(), "Dog");
		Assert.assertEquals(time.getText(), "4 hour(s)");
		
		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
