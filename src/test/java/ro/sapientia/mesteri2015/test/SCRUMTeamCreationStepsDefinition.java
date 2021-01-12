package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMTeamCreationStepsDefinition {

	protected WebDriver driver;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the Teams add page$")
	public void I_open_the_Teams_add_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/scrums/");
	}

	@When("^I enter \"([^\"]+)\" in  the name textbox and I push the add button$")
	public void I_enter_in_the_name_textbox_and_I_push_the_add_button(
			String additionTerms) throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("scrum-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(additionTerms);

		WebElement searchButton = driver.findElement(By.id("add-scrum-button"));
		searchButton.click();
	}

	@Then("^I should get result \"([^\"]+)\" in scrums list$")
	public void I_should_get_result_in_scrums_list(String expectedResult)
			throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("scrums-title"));
		String result = titleTextBox.getText();

		Assert.assertEquals(result, expectedResult);

		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
