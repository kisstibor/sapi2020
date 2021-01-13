package ro.sapientia.mesteri2015.worklog.list;

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

public class ListWorkLogDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^Loggolok (\\d+) veletlenszeru storyra$")
	public void Loggolok_veletlenszeru_storyra(int count) throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int i=0; i<count; ++i) {
			driver.get("http://localhost:8080/worklog/add");
			
			WebElement loggedAtField = driver.findElement(By.id("worklog-logged-ad"));
			loggedAtField.sendKeys("2021-11-1" + i);
			
			WebElement startedAtField = driver.findElement(By.id("worklog-started-at"));
			startedAtField.sendKeys("11:30");
	
			WebElement endedAtField = driver.findElement(By.id("worklog-ended-at"));
			endedAtField.sendKeys("12:30");
			
			WebElement descriptionField = driver.findElement(By.id("worklog-description"));
			descriptionField.sendKeys("proba szoveg");
			
			WebElement logWorkButton = driver.findElement(By.id("add-worklog-button"));
			logWorkButton.click();
		}
	}

	@When("^Megnyomjuk a listazas menugombut$")
	public void Megnyomjuk_a_listazas_menugombut() throws Throwable {
		driver.get("http://localhost:8080/worklog/list/all");
	}

	@Then("^A listaban (\\d+) log kell szerepeljen$")
	public void A_listaban_log_kell_szerepeljen(int arg1) throws Throwable {
		WebElement listContainer = driver.findElement(By.id("worklog-list"));
		String result = listContainer.getText();

		Assert.assertNotEquals(result, "Worklog is emprty");

		driver.close();
	}
	
	@After
	public void closeBrowser() {
		//driver.quit();
	}
	
}
