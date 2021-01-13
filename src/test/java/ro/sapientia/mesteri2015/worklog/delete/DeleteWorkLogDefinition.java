package ro.sapientia.mesteri2015.worklog.delete;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteWorkLogDefinition {
	
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

	@When("^Megnyomjuk a delete gombot es meg egyszer a delete gombot$")
	public void Megnyomjuk_a_delete_gombot_es_meg_egyszer_a_delete_gombot() throws Throwable {
		WebElement deleteLogLink = driver.findElement(By.id("delete-worklog-link"));
		deleteLogLink.click();
		
		WebElement deleteLogBtn = driver.findElement(By.id("delete-worklog-button"));
		deleteLogBtn.click();
	}

	@Then("^A worklog eltunt$")
	public void A_worklog_eltunt() throws Throwable {
		WebElement workLogList = driver.findElement(By.id("worklog-list"));
		String worklogStr = workLogList.getText();
		
		Assert.assertEquals(worklogStr, "Worklog is empty");

		driver.close();
	}
	
	@After
	public void closeBrowser() {
		//driver.quit();
	}
}

