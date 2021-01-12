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

public class SCRUMBugAddStepDefinition {
	
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the scrum tool add bug page$")
	public void I_open_the_scrum_tool_add_bug_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/bug/add");
	}

	@When("I enter \"([^\"]*)\" in the title textbox, \"([^\"]*)\" in the description textbox and I push the add button")
	public void I_enter_in_the_title_textbox_and_description_textbox_and_I_push_the_add_button(String title, String description) throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("bug-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(title);
		
		WebElement descriptionTextBox = driver.findElement(By.id("bug-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(description);

		WebElement addButton = driver.findElement(By.id("add-bug-button"));
		addButton.click();
	}

	@Then("^I should get result \"([^\"]*)\" with \"([^\"]*)\" in bugs list$")
	public void I_should_get_result_in_bugs_list(String expectedTitle, String expectedDescription) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/bug/1");
		
		WebElement titleTextBox = driver.findElement(By.id("bug-title"));
		String resultTitle = titleTextBox.getText();
		
		WebElement descriptionTextBox = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[1]/p"));
		String resultDescription = descriptionTextBox.getText();

		Assert.assertEquals(resultTitle, expectedTitle);
		Assert.assertEquals(resultDescription, expectedDescription);

		//driver.close();
	}
	
	// Second scenario
	
	@When("I enter nothing in the title textbox and I push the add button")
	public void I_enter_nothing_in_the_title_textbox_and_I_push_the_add_button() throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("bug-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys("");

		WebElement addButton = driver.findElement(By.id("add-bug-button"));
		addButton.click();
	}
	
	@Then("^I should get result error message next to title textbox saying \"([^\"]*)\"$")
	public void I_should_get_result_error_message_next_to_title_textbox(String expectedMessage) throws Throwable {
		WebElement errorMessageLabel = driver.findElement(By.id("error-title"));
		String resultMessage = errorMessageLabel.getText();
		
		Assert.assertEquals(resultMessage, expectedMessage);

		//driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
