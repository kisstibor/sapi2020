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

public class UpdateStory {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the add webpage fill inputs and push the add button and then push the update button$")
	public void I_open_the_add_webpage_fill_inputs_and_push_the_add_button_and_then_push_the_update_button() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/add");
		
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
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// find the update button and click it
		WebElement updateButton = driver.findElement(By.id("update-button"));
		updateButton.click();
	}

	@When("^I edit the description and time and then push the update button$")
	public void I_edit_the_description_and_time_and_then_push_the_update_button() throws Throwable {
		// find textbox and inputs
		WebElement titleInput = driver.findElement(By.id("story-title"));
		WebElement descriptionTextbox = driver.findElement(By.id("story-description"));
		WebElement timeInput = driver.findElement(By.id("story-time"));
				
		// clear textbox and inputs
		titleInput.clear();
		descriptionTextbox.clear();
		timeInput.clear();
				
		// fill textbox and inputs with values
		titleInput.sendKeys("CatUPDATED");
		descriptionTextbox.sendKeys("DogUPDATED");
		timeInput.sendKeys("32");
				
		// find the add button and pushing it
		WebElement addButton = driver.findElement(By.id("update-story-button"));
		addButton.click();
	}

	@Then("^I check that the view changed from the first state$")
	public void I_check_that_the_view_changed_from_the_first_state()
			throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		WebElement title = driver.findElement(By.id("story-title"));
		WebElement description = driver.findElement(By.id("story-description"));
		WebElement time = driver.findElement(By.id("story-time"));

		Assert.assertEquals(title.getText(), "CatUPDATED");
		Assert.assertEquals(description.getText(), "DogUPDATED");
		Assert.assertEquals(time.getText(), "32 hour(s)");
		
		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
