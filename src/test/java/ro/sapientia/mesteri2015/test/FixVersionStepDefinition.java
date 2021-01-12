package ro.sapientia.mesteri2015.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
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
	public void I_should_get_result_in_fix_versions_page(String expectedResult)
			throws Throwable {
		WebElement nameTextBox = driver.findElement(By.id("fixVersion-name"));
		String result = nameTextBox.getText();

		Assert.assertEquals(result, expectedResult);

		driver.close();
	}
	
	@And("^I press the update button and change name to \"([^\"]*)\" and press update$")
	public void I_press_the_update_button_annd(String name) throws Throwable {
		WebElement updateButton = driver.findElement(By.id("update-fixVersion-link"));
		updateButton.click();
		
		WebElement nameTextBox = driver.findElement(By.id("fixVersion-name"));
		nameTextBox.clear();
		nameTextBox.sendKeys(name);
		
		updateButton = driver.findElement(By.id("update-fixVersion-button"));
		updateButton.click();
	}
	
	@And("^I press the delete button and confirm the delete$")
	public void I_press_the_delete_button_and_confirm_the_delete() throws Throwable {
		WebElement deleteButton = driver.findElement(By.id("delete-fixVersion-link"));
		deleteButton.click();
		
		deleteButton = driver.findElement(By.id("delete-fixVersion-button"));
		deleteButton.click();
	}
	
	@Then("^I should be redirected to the list all page$")
	public void I_should_be_redirected_to_the_list_all_page()
			throws Throwable {
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "http://localhost:8080/fixVersions");

		driver.close();
	}
	
	@And("^I open the list all fix versions page$")
	public void I_open_the_list_all_fix_versions_page() throws Throwable {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/fixVersions");
	}
	
	@Then("^I should find more or equal than \"([^\"]*)\" fix version$")
	public void I_should_find_more_than_fix_versions(int number)
			throws Throwable {
		
		List<WebElement> versions = driver.findElements(By.name("versions"));

		Assert.assertTrue(versions.size() >= number);

		driver.close();
	}
	
	@And("^I press the update buton and cancel button after$")
	public void I_press_the_update_button_and_cancel_button_after() throws Throwable {
		WebElement updateButton = driver.findElement(By.id("update-fixVersion-link"));
		updateButton.click();
		
		WebElement cancelButton = driver.findElement(By.id("cancel"));
		cancelButton.click();
	}
	
	@And("^I press the delete buton and cancel button after$")
	public void I_press_the_delete_button_and_cancel_button_after() throws Throwable {
		WebElement updateButton = driver.findElement(By.id("delete-fixVersion-link"));
		updateButton.click();
		
		WebElement cancelButton = driver.findElement(By.id("cancel-fixVersion-button"));
		cancelButton.click();
	}
}
