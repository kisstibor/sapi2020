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

public class AddTaskStepDefinition {


	protected WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Gecko\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Given("^I acces the task list page$")
	public void i_acces_the_task_list_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/task");
	}

	@When("^I press the add button$")
	public void i_press_the_add_button() throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
	}

	@Then("^I should enter in the add task page$")
	public void i_should_enter_in_the_add_task_page() throws Throwable {

	   String result = driver.getCurrentUrl();

	    Assert.assertEquals(result, "http://localhost:8080/task/add");
	}

	@Given("^I enter in the title field \"([^\"]*)\"$")
	public void i_enter_in_the_title_field(String additionTerms) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/task/add");
		WebElement titleTextBox = driver.findElement(By.id("task-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(additionTerms);
	}

	@Given("^I enter the \"([^\"]*)\" in the description field$")
	public void i_enter_the_in_the_description_field(String additionTerms) throws Throwable {
		WebElement descriptionTextBox = driver.findElement(By.id("task-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(additionTerms);
	}

	@When("^I press the last add task button$")
	public void i_press_the_last_add_task_button() throws Throwable {
		WebElement addTaskButton = driver.findElement(By.id("add-task-button"));
		addTaskButton.click();
	}

	@Then("^It should appear the new \"([^\"]*)\" in the task list$")
	public void it_should_appear_the_new_in_the_task_list(String expectedResult) throws Throwable {

		Assert.assertTrue(isElementPresent(By.id("task-1")));
	}

	public boolean isElementPresent(By locatorKey) {
	    try {
	        driver.findElement(locatorKey);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
