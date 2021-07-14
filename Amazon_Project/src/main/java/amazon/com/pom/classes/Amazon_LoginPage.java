package amazon.com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_LoginPage {
	
	@FindBy (xpath="(//span[@class='nav-action-inner'])[2]")
	private WebElement signin;
	
	@FindBy (xpath="//input[@type='email']")
	private WebElement email;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement Continuebutton;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="(//input[@type='submit'])[1]")
	private WebElement SignIn;
	
	
	public Amazon_LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonsigin ()
	{
		signin.click();
	}
	
	public void sendEmail ()
	{
		email.sendKeys("Shivamptl143@gmail.com");
	}
		
	public void clickOnContinueButton ()
	{
		Continuebutton.click();
	}
	
	public void sendPassword ()
	{
		password.sendKeys("");
	}
	
	public void clickOnSigIn ()
	{
		SignIn.click();
	}

}
