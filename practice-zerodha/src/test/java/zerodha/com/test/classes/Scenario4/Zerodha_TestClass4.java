package zerodha.com.test.classes.Scenario4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import zerodha.com.pom.classes.Zerodha_Homepage;
import zerodha.com.pom.classes.Zerodha_loginpage;

public class Zerodha_TestClass4 extends Pojo{
	
	WebDriver driver;
	private Actions b;
	private WebElement buy;
	private Zerodha_loginpage login;
	private Zerodha_Homepage homepage;
	
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
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
    	login = new Zerodha_loginpage(driver);
    	homepage = new Zerodha_Homepage(driver);
    }

	@BeforeMethod
	
	public void loginToUserAccount() throws InterruptedException 
	{	
		driver.get("https://kite.zerodha.com/");
		login.setuserid();
		login.setpassword();
		login.verifyloginbutton();
		Thread.sleep(2000);
		login.setpin();
		login.verifyContinuebutton();
		
	}
	
	@Test
	
	public void VerifyMarketOrderStopLoss() throws InterruptedException 
	{
		homepage = new Zerodha_Homepage(driver);
		Thread.sleep(2000);
		homepage.setSearchbar();
		Thread.sleep(2000);
		
		buy = driver.findElement(By.xpath("//*[@class='search-result-item selected isadded']"));
		b = new Actions(driver);
		b.moveToElement(buy).perform();
	    homepage.verifyBuybutton();
	    homepage.verifyFstbtab();
	    homepage.verifyLongtermtab();
	    homepage.verifyMarketorderstoplossbutton();
	    homepage.verifySellbutton();
	    
	}
	
}
