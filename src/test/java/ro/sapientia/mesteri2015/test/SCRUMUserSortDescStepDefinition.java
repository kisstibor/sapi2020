package ro.sapientia.mesteri2015.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import org.openqa.selenium.support.ui.Select;;

public class SCRUMUserSortDescStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I choose Name desc from drop down list$")
	public void I_choose_name_desc_from_drop_down_list() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/scrumsapientia/user");
	}
	
	@When("^We push sort button which sort desc$")
	public void we_push_sort_button_which_sort_desc() throws Throwable {
		Select drpSort=new Select(driver.findElement(By.id("user-title")));
		drpSort.selectByVisibleText("Name desc");
		WebElement sortButton = driver.findElement(By.id("add-user-button"));
		sortButton.click();
			
	}
	
	@Then("^The users are sorted desc$")
	public void the_users_are_sorted() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		ArrayList<String> obtainedList = new ArrayList<String>();
		 List<WebElement> results = driver.findElements(By.id("user-list"));      
		 for(WebElement we:results){
			   obtainedList.add(we.getText());
			}
			ArrayList<String> sortedList = new ArrayList<String>();   
			for(String s:obtainedList){
				sortedList.add(s);
			}
			Collections.sort(sortedList);
			Collections.reverse(sortedList);
			Assert.assertTrue(sortedList.equals(obtainedList));
		driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
