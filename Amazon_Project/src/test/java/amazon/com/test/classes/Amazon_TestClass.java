package amazon.com.test.classes;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.com.pom.classes.Amazon_LoginPage;
import amazon.com.pom.classes.Amazon_MobilePage;


public class Amazon_TestClass {
	
	private WebDriver driver;
	private Amazon_LoginPage amazonloginpage;
	private Amazon_MobilePage mobilelink;
	private ArrayList<String> address;
	private  WebElement ele;
	private Actions ac;
	
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("launch the Amazon");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	
	@BeforeMethod
	public void beforemethod() 
	{
		System.out.println("Login Amazon");
		amazonloginpage = new Amazon_LoginPage (driver);
		amazonloginpage.clickonsigin();
		amazonloginpage.sendEmail();
		amazonloginpage.clickOnContinueButton();
		amazonloginpage.sendPassword();
		amazonloginpage.clickOnSigIn();
	}
	
	@Test
	public void test1() throws InterruptedException 
	{	
		System.out.println("Verify Mobile Tab");
		
		mobilelink=new Amazon_MobilePage(driver);
		Thread.sleep(2000);
		mobilelink.entermobile();
		Thread.sleep(2000);
		mobilelink.entermobileserach();
		Thread.sleep(2000);
		mobilelink.clicksearchmobilebutton();
		Thread.sleep(2000);
		JavascriptExecutor scroll=((JavascriptExecutor)driver);
	
		scroll.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		mobilelink.clickiphone12();
	
		System.out.println(driver.getCurrentUrl());


		address=new   ArrayList<String> (driver.getWindowHandles());  
   
		driver.switchTo().window(address.get(1));
   
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		mobilelink.clickaddtocart();
		mobilelink.clickcart();
		Thread.sleep(2000);
	    driver.navigate().back();
		
	}
	
	
	
	@AfterMethod
	public void aftermethod() throws InterruptedException
	{	
		System.out.println("Logout Amazon");
		JavascriptExecutor scrollup=((JavascriptExecutor)driver);
	       scrollup.executeScript("window.scrollBy(0,-100)");
	       
	      ele=driver.findElement(By.xpath("(//div[@id='nav-tools']//a)[2]"));
			
			ac=new Actions(driver);
			Thread.sleep(3000);
			ac.moveToElement(ele).perform();
	        mobilelink.clickonsignout();
	}
	
	@AfterClass
	public void afterclass() throws InterruptedException
	{	
		Thread.sleep(3000);
		driver.quit();
	}

}
