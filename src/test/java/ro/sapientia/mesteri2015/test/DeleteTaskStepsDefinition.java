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

public class DeleteTaskStepsDefinition {


	protected WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Gecko\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Given("^I acces the task list$")
	public void i_acces_the_task_list() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/task");
	}

	@Given("^I press de add button$")
	public void i_press_de_add_button() throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
	}

	@Given("^I add the title \"([^\"]*)\"$")
	public void i_add_the_title(String additionTerms) throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("task-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(additionTerms);
	}

	@Given("^I add the description \"([^\"]*)\"$")
	public void i_add_the_description(String additionTerms) throws Throwable {
		WebElement descriptionTextBox = driver.findElement(By.id("task-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(additionTerms);
	}

	@Given("^I press the add task button$")
	public void i_press_the_add_task_button() throws Throwable {
		WebElement addTaskButton = driver.findElement(By.id("add-task-button"));
		addTaskButton.click();
	}

	@When("^I acces the task delete page$")
	public void i_acces_the_task_delete_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/task/2");
	}

	@When("^I press the delete task button$")
	public void i_press_the_delete_task_button() throws Throwable {
		WebElement deleteTaskButton = driver.findElement(By.id("delete-task-link"));
		deleteTaskButton.click();
	}

	@When("^I press confirm delete button$")
	public void i_press_confirm_delete_button() throws Throwable {
		WebElement confirmDeleteTaskButton = driver.findElement(By.id("delete-task-button"));
		confirmDeleteTaskButton.click();
	}

	@Then("^I check the task list for task \"([^\"]*)\"$")
	public void i_check_the_task_list_for_task(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/task");

		boolean isTaskDeleted = isElementPresent(By.id("task-2"));
		Assert.assertFalse(isTaskDeleted);
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
