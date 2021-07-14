package amazon.com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_MobilePage {

	
	@FindBy (xpath="(//a[@data-csa-c-type='link'])[4]")
	private WebElement mobile;
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement mobileserach;
	
	@FindBy (xpath="//input[@id='nav-search-submit-button']")
	private WebElement clicksearch;
	
	@FindBy (xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")
	private WebElement iphone12;
	
	@FindBy (xpath="//input[@id='add-to-cart-button']")
	private WebElement clickaddtocart;
	
	@FindBy (xpath="(//input[@type='submit'])[2]")
	private WebElement clickcart;
	
	@FindBy (xpath="//a[@id='nav-item-signout']")
	private WebElement signout;
	
	////////////////////////////////////////////////////////////////////
	
	public Amazon_MobilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//////////////////////////////////////////////////////////////////////
	
	public void entermobile()
        	{
	           	mobile.click();
	        }
	
	public void entermobileserach()
	{
		mobileserach.sendKeys("iphone 12 pro max");
	}
	
	public void clicksearchmobilebutton()
	{
		clicksearch.click();
	}
	
	
	public void clickiphone12()
	{
		iphone12.click();
	}
	
	public void clickaddtocart()
	{
		clickaddtocart.click();
	}
	
	public void clickcart()
	{
		clickcart.click();
	}
	
	public void clickonsignout()
	{
		signout.click();
	}
}
