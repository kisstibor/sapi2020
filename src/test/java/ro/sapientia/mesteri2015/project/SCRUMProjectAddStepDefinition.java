package ro.sapientia.mesteri2015.project;

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

public class SCRUMProjectAddStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the add project page$")
	public void i_open_the_add_project_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/project/add");
	}

	
	
	@When("^I enter \"([^\"]*)\" in  the title textbox and I enter the \"([^\"]*)\" in the description textbox and I push the add project button$")
	public void i_enter_in_the_title_textbox_and_I_enter_the_in_the_description_textbox_and_I_push_the_add_project_button(String title, String description) throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		WebElement projecttitleTextBox = driver.findElement(By.id("epic-title"));
		projecttitleTextBox.clear();
		projecttitleTextBox.sendKeys(title);
		WebElement descriptionTextBox = driver.findElement(By.id("epic-description"));
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(description);

		WebElement addProjectButton = driver.findElement(By.id("add-epic-button"));
		addProjectButton.click();
	}
	


	@Then("^I should get the result \"([^\"]*)\"and\"([^\"]*)\" in projects list$")
	public void i_should_get_the_result_with_the_title_and_description_in_projects_list(String titleResult, String descriptionResult) throws Throwable {
		WebElement projectTitleTextBox = driver.findElement(By.id("epic-title"));
		WebElement projectDescriptionTextBox = driver.findElement(By.id("epic-description"));
		String p1 = projectTitleTextBox.getText();
		String p2 = projectDescriptionTextBox.getText();
		Assert.assertEquals(p1, titleResult);
		Assert.assertEquals(p2, descriptionResult);
	}

	@After
	public void closeBrowser() {
		driver.close();
	}

}