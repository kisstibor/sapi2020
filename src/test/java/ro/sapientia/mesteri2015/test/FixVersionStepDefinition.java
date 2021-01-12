package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FixVersionStepDefinition {

	protected WebDriver driver;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the scrum tool fix version add page$")
	public void I_open_the_scrum_tool_fix_version_add_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/fixVersion/add");
	}
	
	@When("^I enter \"([^\"]*)\" in the name textbox and I press the add button$")
	public void I_enter_in_the_name_textbox_and_I_press_the_add_button(
			String additionTerms) throws Throwable {

		WebElement nameTextBox = driver.findElement(By.id("fixVersion-name"));
		nameTextBox.clear();
		nameTextBox.sendKeys(additionTerms);

		WebElement addButton = driver.findElement(By.id("add-fixVersion-button"));
		addButton.click();
	}
	
	@Then("^I should get result \"([^\"]*)\" in fix version page$")
	public void I_should_get_result_in_fix_versions_list(String expectedResult)
			throws Throwable {
		WebElement nameTextBox = driver.findElement(By.id("fixVersion-name"));
		String result = nameTextBox.getText();

		Assert.assertEquals(result, expectedResult);

		driver.close();
	}
	
	@When("^I press the update button and change name to \"([^\"]*)\" and press update$")
	public void I_press_the_update_button_annd(String name) throws Throwable {
		WebElement updateButton = driver.findElement(By.id("update-fixVersion-link"));
		updateButton.click();
		
		WebElement nameTextBox = driver.findElement(By.id("fixVersion-name"));
		nameTextBox.clear();
		nameTextBox.sendKeys(name);
		
		updateButton = driver.findElement(By.id("update-fixVersion-button"));
		updateButton.click();
	}
}
