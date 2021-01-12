package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMBugDeleteStepDefinition {
	
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open a single bug page$")
	public void I_open_a_single_bug_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/bug/1");
	}

	@When("I click delete button")
	public void I_click_delete_button() throws Throwable {
		WebElement deleteButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/a[2]"));
		deleteButton.click();
	}

	@Then("^I should see the bug is not in the list$")
	public void I_should_see_the_bug_is_not_in_the_list() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/bug/list");
		
		WebElement noBugsLabel = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/p"));
		String noBugsText = noBugsLabel.getText();
		
		Assert.assertEquals(noBugsText, "No bugs added");

		//driver.close();
	}

}
