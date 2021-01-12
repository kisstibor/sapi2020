package ro.sapientia.mesteri2015.update.definition;

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

public class MissingProjectUpdateDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^we list all the projects$")
	public void we_list_all_the_projects() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/projects/");
	}

	@When("^we search for project with id \"([^\"]*)\"$")
	public void we_search_for_project_with_id(final String elementName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/project/update/" + elementName);
		
	}

	@Then("^the project will not be found$")
	public void the_project_will_not_be_found() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//h1"));
		assertEquals("404", element.getText());
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
}
