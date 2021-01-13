package ro.sapientia.mesteri2015.project;

import static org.junit.Assert.assertEquals;

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

public class SCRUMProjectDeleteStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I add a new project and delete it$")
	public void i_add_a_new_project_and_delete_it(final String elementName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/project/list");
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
		WebElement titleTextBox = driver.findElement(By.id("epic-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(elementName);
		WebElement descriptionTextBox = driver.findElement(By.id("epic-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(elementName);
		
		WebElement searchButton = driver.findElement(By.id("add-epic-button"));
		searchButton.click();
	}

	   @When("^I click the delete button$")
		public void i_click_the_delete_button() throws Throwable {
			WebElement deleteLink = driver.findElement(By.id("delete-epic-link"));
			deleteLink.click();
		}

		@Then("^The project disappears$")
		public void the_project_disappears() throws Throwable {
			WebElement storyContainer = driver.findElement(By.id("project-list"));
			assertEquals("No entries found.",storyContainer.getText());
		}
		
		@After
		public void closeBrowser() {
			driver.close();
		}
}