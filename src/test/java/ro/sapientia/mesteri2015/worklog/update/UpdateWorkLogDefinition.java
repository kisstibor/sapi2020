package ro.sapientia.mesteri2015.worklog.update;

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

public class UpdateWorkLogDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^Loggolok \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" idot majd \"([^\"]*)\" leirast adok$")
	public void Loggolok_idot_majd_leirast_adok(String logged_at, String start_at, String end_at, String desc) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/worklog/add");
		
		WebElement loggedAtField = driver.findElement(By.id("worklog-logged-ad"));
		loggedAtField.sendKeys(logged_at);
		
		WebElement startedAtField = driver.findElement(By.id("worklog-started-at"));
		startedAtField.sendKeys(start_at);

		WebElement endedAtField = driver.findElement(By.id("worklog-ended-at"));
		endedAtField.sendKeys(end_at);
		
		WebElement descriptionField = driver.findElement(By.id("worklog-description"));
		descriptionField.sendKeys(desc);
		
		WebElement logWorkButton = driver.findElement(By.id("add-worklog-button"));
		logWorkButton.click();
	}

	@When("^Megnyomjuk az update gombot es beallitjuk a datumot \"([^\"]*)\" es a leirast \"([^\"]*)\"$")
	public void Megnyomjuk_az_update_gombot_es_beallitjuk_a_datumot_es_a_leirast(String logged_at, String desc) throws Throwable {
		WebElement updateBtn = driver.findElement(By.id("update-worklog-btn"));
		updateBtn.click();
		
		WebElement loggedAtField = driver.findElement(By.id("worklog-logged-ad"));
		loggedAtField.sendKeys(logged_at);
		
		WebElement descriptionField = driver.findElement(By.id("worklog-description"));
		descriptionField.sendKeys(desc);
		
		WebElement updateBtnFinal = driver.findElement(By.id("update-worklog-button"));
		updateBtnFinal.click();
	}

	@Then("^A worklog megmodosult \"([^\"]*)\" datum es \"([^\"]*)\" leirassal$")
	public void A_worklog_megmodosult_datum_es_leirassal(String logged_at, String desc) throws Throwable {
		WebElement descriptionTextBox = driver.findElement(By.id("log-description"));
		String result = descriptionTextBox.getText();

		Assert.assertEquals(result, desc);

		driver.close();
	}
	
	@After
	public void closeBrowser() {
		//driver.quit();
	}
}
