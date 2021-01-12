package ro.sapientia.mesteri2015.add.definition;

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

public class ProjectAddDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^we create a new project with name \"([^\"]*)\"$")
	public void we_create_a_new_project_with_name(final String elementName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/projects/");
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
		WebElement titleTextBox = driver.findElement(By.id("project-name"));
		titleTextBox.clear();
		titleTextBox.sendKeys(elementName);

		WebElement searchButton = driver.findElement(By.id("add-project-button"));
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("^we load the projects url$")
	public void we_load_the_project_url() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/projects");
	}

	@Then("^project name is \"([^\"]*)\"$")
	public void hozzaadott_projekt_neve_talal(String expectedProjectName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> projectNames = driver.findElements(By.id("project-name-owner"));
		for (WebElement webEl: projectNames) {
			if (webEl.getText().contains(expectedProjectName)) {
				assertEquals(expectedProjectName + " -", webEl.getText());
				break;
			}
		}
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
}
