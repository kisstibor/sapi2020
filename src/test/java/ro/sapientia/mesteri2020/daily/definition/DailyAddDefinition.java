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

public class DailyAddDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the tool and navigate to the daily add page$")
	public void I_open_the_scrum_tool_add_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/daily/list");
		
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
	}
	
	@When("^I enter \"([^\"]*)\" in  the title textbox, \"([^\"]*)\" in the date textbox, \"([^\"]*)\" in the duration textbox and I push the add button$")
	public void I_enter_in_the_title_textbox_in_the_date_textbox_in_the_duration_textbox_and_I_push_the_add_button(String title, String date, String duration) throws Throwable {
	    

		WebElement titleTextBox = driver.findElement(By.id("daily-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(title);    
		
		WebElement durationTextBox = driver.findElement(By.id("daily-duration"));
		durationTextBox.clear();
		durationTextBox.sendKeys(duration);
		
		WebElement dateTextBox = driver.findElement(By.id("daily-datee"));
		dateTextBox.clear();
		dateTextBox.sendKeys(date);

		WebElement addDailyButton = driver.findElement(By.id("add-daily-button"));
		addDailyButton.click();
	}
	
	@Then("^I should get result \"([^\"]*)\" title \"([^\"]*)\" date \"([^\"]*)\" duration on view page$")
	public void I_should_get_result_title_date_duration_on_view_page(String expectedTitle, String expectedDate, String expectedDuration) throws Throwable {
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
