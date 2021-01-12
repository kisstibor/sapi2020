package ro.sapientia.mesteri2015.log.def;

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

public class LogAddDefinition {
	
	
	
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@Given("^Firefox nyitas es navigalas a logra$")
	public void Firefox_nyitas_es_navigalas_a_logra() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^Log \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" hozzadas$")
	public void Log_hozzadas(String arg1, String arg2, String arg3) throws Throwable {
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		// Write term in google textbox
		WebElement titleTextBox = driver.findElement(By.id("log-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(arg1);
		
		WebElement statusTextBox = driver.findElement(By.id("log-status"));
		statusTextBox.clear();
		statusTextBox.sendKeys(arg2);
		
		WebElement assigntoBox = driver.findElement(By.id("log-assignto"));
		assigntoBox.clear();
		assigntoBox.sendKeys(arg3);
		

		// Click on searchButton
		WebElement searchButton = driver.findElement(By.id("add-log-button"));
		searchButton.click();
	}

	@Then("^Ellenorzes \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" alapjan$")
	public void Ellenorzes_alapjan(String arg1, String arg2, String arg3) throws Throwable {
		WebElement titlebox = driver.findElement(By.id("log-title"));
		String result1 = titlebox.getText();
		
		WebElement statusbox = driver.findElement(By.id("log-status"));
		String result2 = statusbox.getText();
		
		WebElement assigntobox = driver.findElement(By.id("log-assignto"));
		String result3 = assigntobox.getText();

		Assert.assertEquals(result1, arg1);
		Assert.assertEquals(result2, arg2);
		Assert.assertEquals(result3, arg3);

		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
