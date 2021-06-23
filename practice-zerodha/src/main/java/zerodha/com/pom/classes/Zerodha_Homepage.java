package zerodha.com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zerodha_Homepage {
		
	@FindBy (xpath="//input[@type='text']")
	private WebElement SearchBar;
	
	@FindBy (xpath="(//button[@type='button'])[1]")
	private WebElement Tatamotorsbuy;
	
	@FindBy (xpath="//input[@type='text']")
	private WebElement search;
	
	@FindBy (xpath="//label[@class=\"su-switch-control\"]")
	private WebElement FSTB;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[7]")
	private WebElement Longterm;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[8]")
	private WebElement MarketOrder;
	
	@FindBy (xpath="//button[@class=\"submit\"]")
	private WebElement Sell;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[9]")
	private WebElement Limitorder;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[10]")
	private WebElement Limitorderstoploss;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[11]")
	private WebElement Marketorderstoploss;

	
	public Zerodha_Homepage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchbar ()
	{
		SearchBar.sendKeys("Tatamotors");
	}
	
	public void verifyBuybutton ()
	{
		Tatamotorsbuy.click();
	}
	
	public void verifyFstbtab ()
	{
		FSTB.click();
	}
	
	public void verifyLongtermtab ()
	{
		Longterm.click();
	}
	
	public void verifyMarketbutton ()
	{
		MarketOrder.click();
	}
	
	public void verifySellbutton ()
	{
		Sell.click();
	}
	
	public void verifyLimitbutton ()
	{
		Limitorder.click();
	}
	
	public void verifyLimitorderstoplossbutton ()
	{
		Limitorderstoploss.click();
	}
	
	public void verifyMarketorderstoplossbutton ()
	{
		Marketorderstoploss.click();
	}
}
