package ro.sapientia.mesteri2015.update.definition;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProjectUpdateDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^we add a project named \"([^\"]*)\"$")
	public void we_add_a_project_named(final String elementName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/projects/");
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
		WebElement titleTextBox = driver.findElement(By.id("project-name"));
		titleTextBox.clear();
		titleTextBox.sendKeys(elementName);

		WebElement searchButton = driver.findElement(By.id("add-project-button"));
		searchButton.click();
	}

	@When("^we rename the project to \"([^\"]*)\"$")
	public void we_rename_the_project(final String elementName) throws Throwable {
		WebElement updateLink = driver.findElement(By.id("update-project-link"));
		updateLink.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		WebElement nameField = driver.findElement(By.id("project-name"));
		nameField.clear();
		nameField.sendKeys(elementName);
		
		WebElement updateButton = driver.findElement(By.id("update-project-button"));
		updateButton.click();
	}

	@Then("^new project name should be \"([^\"]*)\"$")
	public void new_project_name_should_be(String expectedProjectName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> projectNames = driver.findElements(By.id("project-name-owner"));
		for (WebElement webEl: projectNames) {
			if (webEl.getText().contains(expectedProjectName)) {
				String text = webEl.getText();
				assertEquals(expectedProjectName + " -", text);
				break;
			}
		}
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
}
