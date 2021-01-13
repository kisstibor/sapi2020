package ro.sapientia.mesteri2015.delete.defintion;

import static org.junit.Assert.assertEquals;

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

public class StoryDeleteDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^letrehozunk 1 uj \"([^\"]*)\" element$")
	public void letrehozunk_uj_delete_element(final String elementName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();
		WebElement titleTextBox = driver.findElement(By.id("story-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(elementName);
		WebElement descriptionTextBox = driver.findElement(By.id("story-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(elementName);
		
		WebElement searchButton = driver.findElement(By.id("add-story-button"));
		searchButton.click();
	}

	@When("^megnyomjuk a delete gombot es meg egyszer a delete gombot$")
	public void megnyomjuk_a_delete_gombot_es_meg_egyszer_a_delete_gombot() throws Throwable {
		WebElement deleteLink = driver.findElement(By.id("delete-story-link"));
		deleteLink.click();
		WebElement deleteButton = driver.findElement(By.id("delete-story-button"));
		deleteButton.click();
	}

	@Then("^elem eltunik$")
	public void elem_eltunik() throws Throwable {
		WebElement storyContainer = driver.findElement(By.id("story-list"));
		assertEquals("No entries found.",storyContainer.getText());
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
}
