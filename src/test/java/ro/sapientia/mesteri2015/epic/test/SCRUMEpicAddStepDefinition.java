package ro.sapientia.mesteri2015.epic.test;

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

public class SCRUMEpicAddStepDefinition {
	
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the epic add page$")
	public void i_open_the_epic_add_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/epic");
	}

	@When("^I enter \"([^\"]*)\" in  the title textbox and after that I push the add button$")
	public void i_enter_in_the_title_textbox_and_after_that_I_push_the_add_button(String title) throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("epic-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(title);

		WebElement addEpicButton = driver.findElement(By.id("add-epic-button"));
		addEpicButton.click();
	}

	@Then("^I should get the result \"([^\"]*)\" in epics list$")
	public void i_should_get_the_result_in_epics_list(String titleResult) throws Throwable {
		WebElement epicTitleTextBox = driver.findElement(By.id("epic-title"));
		String result = epicTitleTextBox.getText();
		Assert.assertEquals(result, titleResult);
		//driver.close();
	}
	
	@When("^I enter \"([^\"]*)\" in  the title textbox and I enter the \"([^\"]*)\" in the description textbox after that I push the add button$")
	public void i_enter_in_the_title_textbox_and_I_enter_the_in_the_description_textbox_after_that_I_push_the_add_button(String title, String description) throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("epic-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(title);
		WebElement descriptionTextBox = driver.findElement(By.id("epic-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(description);

		WebElement addEpicButton = driver.findElement(By.id("add-epic-button"));
		addEpicButton.click();
	}

	@Then("^I should get the result with the title \"([^\"]*)\" and description \"([^\"]*)\" in epics list$")
	public void i_should_get_the_result_with_the_title_and_description_in_epics_list(String titleResult, String descriptionResult) throws Throwable {
		WebElement epicTitleTextBox = driver.findElement(By.id("epic-title"));
		WebElement epicDescriptionTextBox = driver.findElement(By.tagName("p"));
		String result1 = epicTitleTextBox.getText();
		String result2 = epicDescriptionTextBox.getText();
		Assert.assertEquals(result1, titleResult);
		Assert.assertEquals(result2, descriptionResult);
		//driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
