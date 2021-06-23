package zerodha.com.pom.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zerodha_Homepage_S3 {
	
	@FindBy (xpath="//input[@type='text']")
	private WebElement SearchBar;
	
	@FindBy (xpath="(//button[@type='button'])[1]")
	private WebElement Tatamotorsbuy;
	
	@FindBy (xpath="//input[@type='text']")
	private WebElement search;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[7]")
	private WebElement Longterm;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[8]")
	private WebElement MarketOrder;
	
	@FindBy (xpath="//button[@class=\"submit\"]")
	private WebElement Buy;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[9]")
	private WebElement Limitorder;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[10]")
	private WebElement Limitorderstoploss;
	
	@FindBy (xpath="(//label[@class=\"su-radio-label\"])[11]")
	private WebElement Marketorderstoploss;

	
	public Zerodha_Homepage_S3 (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonSearchbar ()
	{
		SearchBar.sendKeys("Tatamotors");
	}
	
	public void ClickonBuy ()
	{
		Tatamotorsbuy.click();
	}
	
	public void Clickonsearch ()
	{
		search.sendKeys("Tatamotors");
	}
	
	public void ClickonLongtermtab ()
	{
		Longterm.click();
	}
	
	public void ClickonMarketbutton ()
	{
		MarketOrder.click();
	}
	
	public void ClickonBuybutton ()
	{
		Buy.click();
	}
	
	public void ClickonLimitbutton ()
	{
		Limitorder.click();
	}
	
	public void ClickonLimitorderstoplossbutton ()
	{
		Limitorderstoploss.click();
	}
	
	public void ClickonMarketorderstoplossbutton ()
	{
		Marketorderstoploss.click();
	}
}
