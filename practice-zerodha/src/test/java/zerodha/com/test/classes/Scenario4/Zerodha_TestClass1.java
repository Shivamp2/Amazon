package zerodha.com.test.classes.Scenario4;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.Utility;
import zerodha.com.pom.classes.Zerodha_Homepage;
import zerodha.com.pom.classes.Zerodha_loginpage;
import zerodha.com.pom.classes.Zerodha_logout;




public class Zerodha_TestClass1 extends Pojo {
		
	WebDriver driver;
	
	private Actions b;
	private WebElement buy;
	private Zerodha_loginpage Zerodha_login;
	private Zerodha_Homepage Zerodha_homepage;
	private Zerodha_logout Zerodha_logout;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
	
		reporter = new ExtentHtmlReporter("test-output//ExtendReport//Extent.html"); 
		ExtentReports extend = new ExtentReports();
		extend.attachReporter (reporter);
		System.out.println("Before Test");
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver = openChromeBrowser ();
		}
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			driver = openFirefoxBrowser ();
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	 
    @BeforeClass
    public void creatObject() {
    	Zerodha_login = new Zerodha_loginpage(driver);
    	Zerodha_homepage = new Zerodha_Homepage(driver);
    	Zerodha_logout = new Zerodha_logout(driver);
    }

	@BeforeMethod
	
	public void loginToUserAccount() throws InterruptedException 
	{	
		driver.get("https://kite.zerodha.com/");
		Zerodha_login.setuserid();
		Zerodha_login.setpassword();
		Zerodha_login.verifyloginbutton();
		Thread.sleep(2000);
		Zerodha_login.setpin();
		Zerodha_login.verifyContinuebutton();
		
	}
	
    @Test
	
	public void VerifyMarketOrder() throws InterruptedException 
	{
		
		Thread.sleep(2000);
		Zerodha_homepage.setSearchbar();
		Thread.sleep(2000);
		buy = driver.findElement(By.xpath("//*[@class='search-result-item selected isadded']"));
		b = new Actions(driver);
		b.moveToElement(buy).perform();
		Zerodha_homepage.verifyBuybutton();
		Zerodha_homepage.verifyFstbtab();
	    Zerodha_homepage.verifyLongtermtab();
	    Zerodha_homepage.verifyMarketbutton();
	    Zerodha_homepage.verifySellbutton();
	}
    
//    @Test
//	
//	public void VerifyLimitOrder() throws InterruptedException 
//	{
//		Thread.sleep(2000);
//		Zerodha_homepage.setSearchbar();
//		Thread.sleep(2000);
//		
//		buy = driver.findElement(By.xpath("//*[@class='search-result-item selected isadded']"));
//		b = new Actions(driver);
//		b.moveToElement(buy).perform();
//		Zerodha_homepage.verifyBuybutton();
//		Zerodha_homepage.verifyFstbtab();
//		Zerodha_homepage.verifyLongtermtab();
//		Zerodha_homepage.verifyLimitbutton();
//		Zerodha_homepage.verifySellbutton();
//	}
//
//   @Test
//	
//	public void VerifyLimitOrderStopLoss() throws InterruptedException 
//	{
//		Thread.sleep(2000);
//		Zerodha_homepage.setSearchbar();
//		Thread.sleep(2000);
//		
//		buy = driver.findElement(By.xpath("//*[@class='search-result-item selected isadded']"));
//		b = new Actions(driver);
//		b.moveToElement(buy).perform();
//		Zerodha_homepage.verifyBuybutton();
//		Zerodha_homepage.verifyFstbtab();
//		Zerodha_homepage.verifyLongtermtab();
//	    Zerodha_homepage.verifyLimitorderstoplossbutton();
//	    Zerodha_homepage.verifySellbutton();	    
//	}
//
//   @Test
//	
//	public void VerifyMarketOrderStopLoss() throws InterruptedException 
//	{
//		Thread.sleep(2000);
//		Zerodha_homepage.setSearchbar();
//		Thread.sleep(2000);
//		buy = driver.findElement(By.xpath("//*[@class='search-result-item selected isadded']"));
//		b = new Actions(driver);
//		b.moveToElement(buy).perform();
//		Zerodha_homepage.verifyBuybutton();
//		Zerodha_homepage.verifyFstbtab();
//	    Zerodha_homepage.verifyLongtermtab();
//	    Zerodha_homepage.verifyMarketorderstoplossbutton();
//	    Zerodha_homepage.verifySellbutton();
//	}
   
   @AfterMethod 
   
   public void LogoutAccount (ITestResult result) throws InterruptedException, IOException {
	   if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshot(driver);
		}
	   Thread.sleep(2000);
	   Zerodha_logout.verifyprofile();
	   Zerodha_logout.verifylogout();
	   Thread.sleep(2000);
	   Zerodha_logout.verifychangeuser();
   }
   
   @AfterClass
   public void clearObjects() {
	   
	   Zerodha_login = null;
	   Zerodha_homepage = null;
	   Zerodha_logout = null;
   }
   
   @AfterTest
   
   public void closeBrowserChrome() {
	   driver.quit();
	   driver = null;
	   System.gc();
   }
   

}
