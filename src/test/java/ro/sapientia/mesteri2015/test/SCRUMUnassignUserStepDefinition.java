package ro.sapientia.mesteri2015.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMUnassignUserStepDefinition {
		
	@Before
	public void setup() {
		WebDriverHelper.openBrowser();
	}
	
	@Given("^I open the scrum tool story edit page$")
	public void I_open_the_scrum_tool_story_edit_page() throws Throwable {
		WebDriverHelper.get("http://localhost:8080/");
		
		List<WebElement> anchors = WebDriverHelper.findElements(By.cssSelector("#story-list > div > a"));
		anchors.get(0).click();
		
		WebElement updateButton = WebDriverHelper.findElement(By.id("action-update-button"));
		updateButton.click();
	}

	@When("^I deselect the user from the combo box and I push the \"Update\" button$")
	public void I_deselect_the_user_from_the_combo_box_and_I_push_the_Update_button() throws Throwable {
		Select userComboBox = new Select(WebDriverHelper.findElement(By.id("story-user")));
		userComboBox.selectByIndex(0);
		
		WebElement filterButton = WebDriverHelper.findElement(By.id("update-story-button"));
		filterButton.click();
	}

	@Then("^I should not see the \"Assigned to: user1\" text on the detail page$")
	public void I_should_not_see_the_Assigned_to_user1_text_on_the_detail_page() throws Throwable {
		boolean elementFound = true;
		try {
			WebDriverHelper.findElement(By.id("assignedTo"));
		}
		catch (NoSuchElementException ex) {
			elementFound = false;
		}
		
		Assert.assertFalse(elementFound);
	}
	
	@After
	public void closeBrowser() {
		WebDriverHelper.closeBrowser();
	}

}
