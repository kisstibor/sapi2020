package ro.sapientia.mesteri2015.delete.defintion;

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
import junit.framework.Assert;

public class ProjectDeleteDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^we add a new project named \"([^\"]*)\"$")
	public void we_add_a_new_project_named(final String elementName) throws Throwable {
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

	@When("^we delete the project$")
	public void we_delete_the_project() throws Throwable {
		WebElement deleteLink = driver.findElement(By.id("delete-project-link"));
		deleteLink.click();
		WebElement deleteButton = driver.findElement(By.id("delete-project-button"));
		deleteButton.click();
	}

	@Then("^check if \"([^\"]*)\" has been deleted$")
	public void check_if_has_been_deleted(final String elementName) throws Throwable {
		List<WebElement> projectContainer = driver.findElements(By.id("project-name-owner"));
		for (WebElement webEl: projectContainer) {
			if (webEl.getText().contains(elementName)) {
				Assert.fail("Project still in existing projects list");
			}
		}
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
}
