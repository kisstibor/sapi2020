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

public class TimeInputsExistsOnAddPage {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the base webpage$")
	public void I_open_the_base_webpage() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I push the ADD button$")
	public void I_push_the_ADD_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
	}

	@Then("^I check that the time related elements exists on page$")
	public void I_check_that_the_time_related_elements_exists_on_page()
			throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// find the "Spent time:" text element
		// WebElement timeLabel = driver.findElement(By.id(id));
		// find the textbox 
		boolean elementFounded = false;
		try {
			WebElement timeInputField = driver.findElement(By.id("story-time"));
			elementFounded = true;
		} catch(Exception e) {
			elementFounded = false;
		} finally {
			assert(elementFounded);
		}

		// Verify that result of 2+2 is 4
		// Assert.assertEquals(result, expectedResult);

		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
