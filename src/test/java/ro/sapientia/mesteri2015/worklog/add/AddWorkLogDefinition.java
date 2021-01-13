package ro.sapientia.mesteri2015.worklog.add;

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

public class AddWorkLogDefinition {
	
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^Megnyitom az uj worklog hozzaadas oldalt$")
	public void Megnyitom_az_uj_worklog_hozzaadas_oldalt() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/worklog/add");
	}

	@When("^Kivalasztom az elso sztorit es \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" idot majd \"([^\"]*)\" leirast adok$")
	public void Kivalasztom_az_elso_sztorit_es_idot_majd_leirast_adok(String logged_at, String start_at, String end_at, String desc) throws Throwable {
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

	@Then("^Az uj worklog megjelenik \"([^\"]*)\" leirassal$")
	public void Az_uj_worklog_megjelenik_leirassal(String descr) throws Throwable {
		WebElement descriptionTextBox = driver.findElement(By.id("log-description"));
		String result = descriptionTextBox.getText();

		Assert.assertEquals(result, descr);

		driver.close();
	}
	
	@After
	public void closeBrowser() {
		//driver.quit();
	}
}
