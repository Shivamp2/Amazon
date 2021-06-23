package zerodha.com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zerodha_logout {
	
	@FindBy (xpath="//span[@class=\"user-id\"]")
	private WebElement profileEZ5871;
	
	@FindBy (xpath="//a[@href=\"/logout\"]")
	private WebElement Logout;
	
	@FindBy (xpath="//a[@href=\"#\"]")
	private WebElement Changeuser;
	
	public Zerodha_logout (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyprofile ()
	{
		profileEZ5871.click();
	}
	
	public void verifylogout ()
	{
		Logout.click();
	}
	
	public void verifychangeuser ()
	{
		Changeuser.click();
	}
}
