package ro.sapientia.mesteri2015.epic.test;

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

public class SCRUMEpicDeleteStepDefinition {
	
	protected WebDriver driver;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I click on the epic list's first element to delete it$")
	public void i_click_on_the_epic_list_s_first_element_to_delete_it() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/epic");
	}
	
	@When("^I click the delete button and a dialog appears and i confirm my choice$")
	public void i_click_the_delete_button_and_a_dialog_appears_and_i_confirm_my_choice() throws Throwable {
		WebElement firstElement = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[1]/a"));
		firstElement.click();
		
		WebElement deleteButton = driver.findElement(By.id("delete-epic-link"));
		deleteButton.click();
		
		WebElement deleteConfirmButton = driver.findElement(By.xpath("//*[@id=\"delete-epic-button\"]"));
		deleteConfirmButton.click();
	}

	@Then("^I should see  a \"([^\"]*)\" text$")
	public void i_should_see_a_text(String firtElementResult) throws Throwable {
		WebElement firstElementText = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/a"));
		String result = firstElementText.getText();
		Assert.assertEquals(result, firtElementResult);
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
