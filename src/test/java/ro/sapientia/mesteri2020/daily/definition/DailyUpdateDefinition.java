package ro.sapientia.mesteri2020.daily.definition;

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

public class DailyUpdateDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	
	@Given("^I open the tool and navigate to an existing daily with title \"([^\"]*)\", duration \"([^\"]*)\", date \"([^\"]*)\"$")
	public void I_open_the_tool_and_navigate_to_an_existing_daily_with_title_duration_date(String expectedTitle, String expectedDuration, String expectedDate) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/daily/list");
		
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
		
		WebElement titleTextBox = driver.findElement(By.id("daily-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(expectedTitle);    
		
		WebElement durationTextBox = driver.findElement(By.id("daily-duration"));
		durationTextBox.clear();
		durationTextBox.sendKeys(expectedDuration);
		
		WebElement dateTextBox = driver.findElement(By.id("daily-datee"));
		dateTextBox.clear();
		dateTextBox.sendKeys(expectedDate);

		WebElement addDailyButton = driver.findElement(By.id("add-daily-button"));
		addDailyButton.click();
		
		WebElement title = driver.findElement(By.id("daily-title"));
		String result = title.getText();

		Assert.assertEquals(result, expectedTitle);
		
		WebElement date = driver.findElement(By.id("daily-datee"));
		String datee = date.getText();

		Assert.assertEquals(datee, "Date: " + expectedDate);
		
		WebElement duration = driver.findElement(By.id("daily-duration"));
		String durationn = duration.getText();

		Assert.assertEquals(durationn, "Duration: " + expectedDuration);
	}

	@When("^I press update button$")
	public void I_press_update_button() throws Throwable {
		WebElement updateButton = driver.findElement(By.id("update-button"));
		updateButton.click();
	}

	@When("^Check title to be \"([^\"]*)\", duration \"([^\"]*)\", date \"([^\"]*)\"$")
	public void Check_title_to_be_duration_date(String expectedTitle, String expectedDuration, String expectedDate) throws Throwable {
		WebElement title = driver.findElement(By.id("daily-title"));
		String result = title.getAttribute("value");

		Assert.assertEquals(result, expectedTitle);
		
		WebElement date = driver.findElement(By.id("daily-datee"));
		String datee = date.getAttribute("value");

		Assert.assertEquals(datee, expectedDate);
		
		WebElement duration = driver.findElement(By.id("daily-duration"));
		String durationn = duration.getAttribute("value");

		Assert.assertEquals(durationn, expectedDuration);
	}

	@When("^I change title to \"([^\"]*)\" and press update$")
	public void I_change_title_to_and_press_update(String title) throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("daily-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(title);  
		
		WebElement updateButton = driver.findElement(By.id("update-daily-button"));
		updateButton.click();
	}
	
	@Then("^I should get result \"([^\"]*)\" title \"([^\"]*)\" date \"([^\"]*)\" duration after update$")
	public void I_should_get_result_title_date_duration_after_update(String expectedTitle, String expectedDate, String expectedDuration) throws Throwable {
		WebElement title = driver.findElement(By.id("daily-title"));
		String result = title.getText();

		Assert.assertEquals(result, expectedTitle);
		
		WebElement date = driver.findElement(By.id("daily-datee"));
		String datee = date.getText();

		Assert.assertEquals(datee, "Date: " + expectedDate);
		
		WebElement duration = driver.findElement(By.id("daily-duration"));
		String durationn = duration.getText();

		Assert.assertEquals(durationn, "Duration: " + expectedDuration);
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
