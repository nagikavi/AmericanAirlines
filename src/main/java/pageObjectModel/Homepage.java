package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Homepage {
	
	public WebDriver driver;
	WebElement foot;
	
	
	public  Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By aa=By.xpath("//img[@alt='American Airlines']");
	private By pt=By.id("plan-travel-expander");
	private By travInfo=By.id("travel-information-expander");
	private By aadv=By.id("aadvantage-expander");
	private By login=By.id("loginLogoutLink");
	private By searchbox=By.id("aa-search-field");
	private By from=By.name("originAirport");
	private By to=By.name("destinationAirport");
	private By numPass=By.name("adultOrSeniorPassengerCount");
	private By depDate=By.id("aa-leavingOn");
	private By retDate=By.id("aa-returningFrom");
	private By search=By.id("flightSearchForm.button.reSubmit");
	private By travRest=By.id("linkCancelTrip");
	private By travText=By.xpath("//h2[contains(text(),'Travel restrictions')]");
	private By depWind=By.cssSelector("li[class='ui-menu-item'] a");
	private By arrWind=By.xpath("//ul[@id='ui-id-2']//li[@class='ui-menu-item']");
	private By selMonth=By.xpath("//div[contains(@class,'ui-datepicker-group')]//div[@class='ui-datepicker-title']");
	private By corButton=By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//a[@class='ui-datepicker-next ui-corner-all']");
	private By selDate=By.xpath("//div[contains(@class,'ui-datepicker-group')]//td[@data-event='click']");
	private By links=By.tagName("a");
	private By footer=By.id("aa-footer");
	private By footerLink=By.xpath("//footer[@id='aa-footer']//a");
	private By firstColFooter=By.xpath("//footer[@id='aa-footer']//div[@class='span3 span-tablet4']//a");
	private By thirdColFooter=By.xpath("//footer[@id='aa-footer']//div[contains(@class,'row')]//div[3]//a");
	
	
	public WebElement aaLogo()
	{
		return driver.findElement(aa);
	}
	
	public WebElement planTravel()
	{
		return driver.findElement(pt);
	}
	
	public Travelinformationpage travelInfo()
	{
		 driver.findElement(travInfo).click();
		 Travelinformationpage tp= new Travelinformationpage(driver);
		 return tp;
	}
	
	public WebElement aAdvantage()
	{
		return driver.findElement(aadv);
	}
	
	public Loginpage logIn()
	{
		driver.findElement(login).click();
		Loginpage lp= new Loginpage(driver);
		return lp;
	}
	
	public WebElement searchBox()
	{
		return driver.findElement(searchbox);
	}
	
	public WebElement departure()
	{
		return driver.findElement(from);
	}
	
	public WebElement arrival()
	{
		return driver.findElement(to);
	}
	
	public WebElement passengerCount()
	{
		return driver.findElement(numPass);
	}
	
	public WebElement departureBox()
	{
		return driver.findElement(depDate);
	}
	
	public WebElement returnBox()
	{
		return driver.findElement(retDate);
	}
	
	public WebElement searchButton()
	{
		return driver.findElement(search);
	}
	
	public WebElement travelRestriction()
	{
		return driver.findElement(travRest);
	}
	
	public WebElement travelText()
	{
		return driver.findElement(travText);
	}
	
	public WebElement depatWindow()
	{
		return driver.findElement(depWind);
	}
	
	public WebElement arrivalWindow()
	{
		return driver.findElement(arrWind);
	}
	
	public List<WebElement> depatWindowList()
	{
		return driver.findElements(depWind);
	}
	
	public List<WebElement> arrivalWindowList()
	{
		return driver.findElements(arrWind);
	}
	
	public WebElement selectingMonth()
	{
		return driver.findElement(selMonth);
	}
	
 	public WebElement nextButton()
	{
		return driver.findElement(corButton);
	} 
 	
 	public List<WebElement> selectDateList()
	{
		return driver.findElements(selDate);
	} 
 	
 	public List<WebElement> linkCount()
 	{
 		return driver.findElements(links);
 	}
 	
 	public List<WebElement> footerLinks()
 	{
 		return driver.findElements(footerLink);
 		
 	}	
 	 	
 	public List<WebElement> firstColumnOfFooter()
 	{
		return driver.findElements(firstColFooter);
 	}	
 	
 	public List<WebElement> thirdColumnOfFooter()
 	{
		return driver.findElements(thirdColFooter);
 	}	
}
