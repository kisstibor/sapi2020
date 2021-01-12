package ro.sapientia.mesteri2015.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverHelper {

	private static final long WAIT_TIMEOUT = 10;
	private static WebDriver driver = null;
	private static int counter = 0;
	
	public static void openBrowser() {
		counter++;
		if (driver == null) {
			driver = new FirefoxDriver();
			Options options = driver.manage();
			options.window().maximize();
			options.timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
		}
	}
	
	public static void get(String url) {
		driver.get(url);
	}
	
	public static WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	public static List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}
	
	public static void closeBrowser() {
		counter--;
		if (counter == 0) {
			driver.quit();
			driver = null;
		}
	}
	
}
