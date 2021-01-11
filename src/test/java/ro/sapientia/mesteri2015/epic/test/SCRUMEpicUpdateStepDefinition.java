package ro.sapientia.mesteri2015.epic.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMEpicUpdateStepDefinition {
	
	protected WebDriver driver;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I click on the epic list's first element$")
	public void i_click_on_the_epic_list_s_first_element() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/epic");
	}

	@When("^I enter \"([^\"]*)\" in  the title textbox and after that I push the update button$")
	public void i_enter_in_the_title_textbox_and_after_that_I_push_the_update_button(String updateTitle) throws Throwable {
		WebElement firstElement = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[1]/a"));
		firstElement.click();
		
		WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/a[1]"));
		updateButton.click();

		WebElement titleField = driver.findElement(By.id("epic-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(updateTitle);
		
		WebElement updateEpicButton = driver.findElement(By.id("update-epic-button"));
		updateEpicButton.click();
	}

	@Then("^I should get the result \"([^\"]*)\" in new epics list$")
	public void i_should_get_the_result_in_new_epics_list(String titleResult) throws Throwable {
		WebElement titleText = driver.findElement(By.id("epic-title"));
		String result = titleText.getText();
		Assert.assertEquals(result, titleResult);
		//driver.close();
	}
	
	@When("^I enter \"([^\"]*)\" in  the title textbox and \"([^\"]*)\" in the description textbox after that I push the update button$")
	public void i_enter_in_the_title_textbox_and_in_the_description_textbox_after_that_I_push_the_update_button(String updateTitle, String updateDescription) throws Throwable {
		WebElement firstElement = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[1]/a"));
		firstElement.click();
		
		WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/a[1]"));
		updateButton.click();


		WebElement titleField = driver.findElement(By.id("epic-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(updateTitle);
		
		WebElement descriptionField = driver.findElement(By.id("epic-description"));
		descriptionField.sendKeys(Keys.CONTROL + "a");
		descriptionField.sendKeys(Keys.DELETE);
		descriptionField.sendKeys(updateDescription);
		
		WebElement updateEpicButton = driver.findElement(By.id("update-epic-button"));
		updateEpicButton.click();
	}

	@Then("^I should get the result with title \"([^\"]*)\" and description \"([^\"]*)\" in new epics list$")
	public void i_should_get_the_result_with_title_and_description_in_new_epics_list(String titleResult, String descriptionResult) throws Throwable {
		WebElement titleText = driver.findElement(By.id("epic-title"));
		WebElement descriptionText = driver.findElement(By.tagName("p"));
		String result1 = titleText.getText();
		String result2 = descriptionText.getText();
		Assert.assertEquals(result1, titleResult);
		Assert.assertEquals(result2, descriptionResult);
		//driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}


}
