package ro.sapientia.mesteri2015.worklog.search;

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

public class SearchWorkLogDefinition {
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^Loggolok (\\d+) veletlenszeru elemet, ebbol (\\d+) \"([^\"]*)\" datumra$")
	public void Loggolok_veletlenszeru_elemet_ebbol_datumra(int diff_count, int same_count, String same_log_date) throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int i=0; i<diff_count; ++i) {
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
		
		for (int i=0; i<same_count; ++i) {
			driver.get("http://localhost:8080/worklog/add");
			
			WebElement loggedAtField = driver.findElement(By.id("worklog-logged-ad"));
			loggedAtField.sendKeys(same_log_date);
			
			WebElement startedAtField = driver.findElement(By.id("worklog-started-at"));
			startedAtField.sendKeys("0" + i + ":30");
	
			WebElement endedAtField = driver.findElement(By.id("worklog-ended-at"));
			endedAtField.sendKeys("1" + i + ":30");
			
			WebElement descriptionField = driver.findElement(By.id("worklog-description"));
			descriptionField.sendKeys("proba szoveg");
			
			WebElement logWorkButton = driver.findElement(By.id("add-worklog-button"));
			logWorkButton.click();
		}
	}

	@When("^Kivalasztom a \"([^\"]*)\" datumot es megnyomom s search gombot$")
	public void Kivalasztom_a_datumot_es_megnyomom_s_search_gombot(String logged_at) throws Throwable {
		driver.get("http://localhost:8080/worklog/list/all");
		WebElement loggedAtField = driver.findElement(By.id("worklog-logged-ad"));
		loggedAtField.sendKeys(logged_at);
		
		WebElement searchLink = driver.findElement(By.id("search-by-date-btn"));
		searchLink.click();
	}

	@Then("^A lista ket elemet fog tartalmazni$")
	public void A_lista_ket_elemet_fog_tartalmazni() throws Throwable {
		WebElement listContainer = driver.findElement(By.id("worklog-list"));
		String result = listContainer.getText();

		Assert.assertNotEquals(result, "Worklog is empty");

		driver.close();
	}
	
	@After
	public void closeBrowser() {
		//driver.quit();
	}
}
