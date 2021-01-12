package ro.sapientia.mesteri2015.test.Time;

import java.util.List;
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

public class IsTheCreatedStoryListedOnHome {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the add story page$")
	public void I_open_the_add_story_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/story/add");
	}

	@When("^I fill all data and then navigate to home$")
	public void I_fill_all_data_and_then_navigate_to_home() throws Throwable {
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
		titleInput.sendKeys("Cattttt");
		descriptionTextbox.sendKeys("Dog");
		timeInput.sendKeys("13");
		
		// find the add button and pushing it
		WebElement addButton = driver.findElement(By.id("add-story-button"));
		addButton.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@Then("^I check on the home page that the story is listed with the given time$")
	public void I_check_on_the_home_page_that_the_story_is_listed_with_the_given_time()
			throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		List<WebElement> titles = driver.findElements(By.id("list-story-element-title"));
		List<WebElement> times = driver.findElements(By.id("list-story-element-time"));

		int i;
		for(i = 0; i < titles.size(); ++i) {
			System.out.println(titles.get(i).getText());
			if(titles.get(i).getText().equals("Cattttt")) { break; }
		}
		
		if(i == titles.size()) {
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(titles.get(i).getText(), "Cattttt");
			Assert.assertEquals(times.get(i).getText(), "13 hour(s)");
		}
		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
