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

public class UpdateTaskStepsDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Gecko\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Given("^I access the task page$")
	public void i_access_the_task_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/task");
	}

	@Given("^I create a new task with title \"([^\"]*)\" and description \"([^\"]*)\"$")
	public void i_create_a_new_task_with_title_and_description(String title, String description) throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement titleTextBox = driver.findElement(By.id("task-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(title);

		WebElement descriptionTextBox = driver.findElement(By.id("task-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(description);

		WebElement addTaskButton = driver.findElement(By.id("add-task-button"));
		addTaskButton.click();
	}

	@Given("^I access the new task$")
	public void i_access_the_new_task() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/task/1");

	}

	@When("^I press the update button$")
	public void i_press_the_update_button() throws Throwable {
		WebElement updateTaskButton = driver.findElement(By.id("action-update-button"));
		updateTaskButton.click();
	}

	@When("^Update the Task with title \"([^\"]*)\" and description \"([^\"]*)\"$")
	public void update_the_Task_with_title_and_description(String title, String description) throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("task-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(title);

		WebElement descriptionTextBox = driver.findElement(By.id("task-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(description);

		WebElement updateTaskButton = driver.findElement(By.id("update-task-button"));
		updateTaskButton.click();
	}

	@Then("^I would see a Task with updated title and description$")
	public void i_would_see_a_Task_with_updated_title_and_description() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/task/1");

		WebElement element1 = driver.findElement(By.id("task-title"));
		String title = element1.getText();
		WebElement element2 = driver.findElement(By.id("task-description"));

		String description = element2.getText();

		Assert.assertEquals(title,"Updated Task" );

		Assert.assertEquals(description,"I am the updater!" );
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
