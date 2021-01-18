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

public class LogUpdate {
	
	
	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	
	@Given("^Firefox nyitas$")
	public void Firefox_nyitas() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@Given("^Letrehozok egy uj logot: \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void Letrehozok_egy_uj_logot_(String arg1, String arg2, String arg3) throws Throwable {
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
	}

	@When("^Kattintas az update gombra$")
	public void Kattintas_az_update_gombra() throws Throwable {
		WebElement updateButton = driver.findElement(By.id("action-update-button"));
		updateButton.click();
	}

	@When("^Status es Assingto modositas \"([^\"]*)\" , \"([^\"]*)\"$")
	public void Status_es_Assingto_modositas_(String arg1, String arg2) throws Throwable {
		WebElement titleTextBox = driver.findElement(By.id("log-title"));
		titleTextBox.clear();
		titleTextBox.sendKeys(arg1);
		
		WebElement statusTextBox = driver.findElement(By.id("log-assignto"));
		statusTextBox.clear();
		statusTextBox.sendKeys(arg2);
	}

	@Then("^Ellenorzes \"([^\"]*)\" , \"([^\"]*)\" ertekek megvaltoztake?$")
	public void Ellenorzes_ertekek_megvaltoztake(String arg1, String arg2) throws Throwable {
		WebElement titlebox = driver.findElement(By.id("log-title"));
		String result1 = titlebox.getText();
		
		
		
		WebElement assigntobox = driver.findElement(By.id("log-assignto"));
		String result2 = assigntobox.getText();

		Assert.assertEquals(result1, arg1);
		Assert.assertEquals(result2, arg2);
		

		driver.close();
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
