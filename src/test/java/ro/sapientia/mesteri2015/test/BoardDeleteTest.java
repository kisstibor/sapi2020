package ro.sapientia.mesteri2015.test;

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

public class SCRUMTitleStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the board page$")
	public void I_open_the_board_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/board/show/1");
	}

	@When("^I push delete$")
	public void I_push_delete() throws Throwable {
				
		WebElement button = driver.findElement(By.id("delete-story-link"));
		button.click();
		
		WebElement button = driver.findElement(By.id("delete-task-button"));
		button.click();
		
		
	}

	@Then("^I should get empty board$")
	public void I_should_get_result_on_board()
			throws Throwable {
		WebElement card = driver.findElement(By.className("card"));

		Assert.assertNull(card);

		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
