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
		driver.get("http://localhost:8080/board");
	}

	@When("^I see a task in In Progress and move it to Done$")
	public void I_see_a_task_in_In_Progress_and_move_it_Done(
			String additionTerms) throws Throwable {

		driver.findElement(By.LinkText(">>")).Click();

	}

	@Then("^I should see it in Done$")
	public void I_should_see_it_in_Done()
			throws Throwable {
		WebElement card = driver.find_element(By.XPATH, "*//tbody/tr[3]/td/div[contains(@class, 'card')]")

		Assert.assertNotNull(card);

		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
