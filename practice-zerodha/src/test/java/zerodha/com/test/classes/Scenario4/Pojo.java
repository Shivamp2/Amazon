package zerodha.com.test.classes.Scenario4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Pojo {
      
	public static WebDriver openChromeBrowser () {
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("disable-notifications");
	WebDriver driver=new ChromeDriver(options);
	return driver;
	
	}
	
	public static WebDriver openFirefoxBrowser () {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new FirefoxDriver (options);
		return driver;
		
		}
	
}
