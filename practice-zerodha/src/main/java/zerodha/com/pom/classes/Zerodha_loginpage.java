package zerodha.com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zerodha_loginpage {
	
	@FindBy (xpath="//input[@id=\"userid\"]")
	private WebElement userid;
	
	@FindBy (xpath="//input[@id=\"password\"]")
	private WebElement password;
	
	@FindBy (xpath="//button[@class=\"button-orange wide\"]")
	private WebElement login;
	
	@FindBy (xpath="//input[@type=\"password\"]")
	private WebElement pin;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement Continue;
	
	
	
	public Zerodha_loginpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setuserid ()
	{
		userid.sendKeys("EZ5871");
	}
	
	public void setpassword ()
	{
		password.sendKeys("Vmore@257");
	}
	
	public void verifyloginbutton ()
	{
		login.click();
	}
	
	public void setpin ()
	{
		pin.sendKeys("887945");
	}
	
	public void verifyContinuebutton ()
	{
		Continue.click();
	}
	

}
