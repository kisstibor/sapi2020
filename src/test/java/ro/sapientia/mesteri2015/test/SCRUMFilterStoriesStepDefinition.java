package ro.sapientia.mesteri2015.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMFilterStoriesStepDefinition {
	
	protected WebDriver driver;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the scrum tool story list page$")
	public void I_open_the_scrum_tool_story_list_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I enter \"([^\"]*)\" in the filter textbox and I push the \"Filter\" button$")
	public void I_enter_story_in_the_filter_textbox_and_I_push_the_Filter_button(String filterText) throws Throwable {
		WebElement storyTitleFilterInput = driver.findElement(By.id("query-text"));
		storyTitleFilterInput.clear();
		storyTitleFilterInput.sendKeys(filterText);
		
		WebElement filterButton = driver.findElement(By.id("filter-button"));
		filterButton.click();
	}

	@Then("^I should get a single result: \"([^\"]*)\"$")
	public void I_should_get_a_single_result_Story_for_user1(String expectedStoryTitle) throws Throwable {
		List<WebElement> innerDivs = driver.findElements(By.cssSelector("#story-list > div"));
		Assert.assertEquals(1, innerDivs.size());
		
		WebElement anchor = innerDivs.get(0).findElement(By.cssSelector("a"));
		String actualStoryTitle = anchor.getText();
		Assert.assertEquals(expectedStoryTitle, actualStoryTitle);

		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
