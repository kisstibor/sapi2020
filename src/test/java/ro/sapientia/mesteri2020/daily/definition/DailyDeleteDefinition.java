package ro.sapientia.mesteri2020.daily.definition;

import static org.junit.Assert.assertEquals;

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

public class DailyDeleteDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the tool and create a daily with title \"([^\"]*)\", duration \"([^\"]*)\", date \"([^\"]*)\"$")
	public void I_open_the_tool_and_create_a_daily_with_title_duration_date(String expectedTitle, String expectedDuration, String expectedDate) throws Throwable {
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

	@When("^I press delete button$")
	public void I_press_delete_button() throws Throwable {
		WebElement updateButton = driver.findElement(By.id("delete-daily-link"));
		updateButton.click();
	}

	@When("^I confirm delete$")
	public void I_confirm_delete() throws Throwable {
		WebElement deleteButton = driver.findElement(By.id("delete-daily-button"));
		deleteButton.click();
	}

	
	//abban az esetben ha ures listaval kezdunk ^_^
	@Then("^I puufff its deleted$")
	public void I_puufff_its_deleted() throws Throwable {
		WebElement container = driver.findElement(By.id("daily-list"));
		assertEquals("No entries found.",container.getText());
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
	
}
