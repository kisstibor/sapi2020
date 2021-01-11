package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StoryPointListStepDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^I open the scrum tool story point list page$")
	public void I_open_the_scrum_tool_story_point_list_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I navigate the Story point list page$")
	public void I_navigate_the_Story_point_list_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement link = driver.findElement(By.linkText("Point list"));
		link.click();
	}
	
	@Then("^I see dashboard with numbers$")
	public void I_see_dashboard_with_numbers() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement totalPoint = driver.findElement(By.id("total-point"));
		String resultTotal = totalPoint.getText();
		
		WebElement averagePoint = driver.findElement(By.id("average-point"));
		String resultAverage = averagePoint.getText();

		// Verify that result of 2+2 is 4
		Assert.assertNotNull(resultTotal);
		Assert.assertNotNull(resultAverage);
		//Assert.assertNotSame(result, expectedResult);
		driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
