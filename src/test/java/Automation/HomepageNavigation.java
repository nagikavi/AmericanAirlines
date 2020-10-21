package Automation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.Homepage;
import pageObjectModel.Loginpage;
import resources.Base;

public class HomepageNavigation extends Base{
	
	public WebDriver driver;
	Homepage hp;
	private static Logger log= LogManager.getLogger(HomepageNavigation.class.getName());
	
	@BeforeTest
	public void initializesDriver() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		hp=new Homepage(driver);
	}
	
	@Test
	public void hpNavigation() throws IOException, InterruptedException
	{
		
	
		//hp=new Homepage(driver);
		Thread.sleep(2000);
		System.out.println(hp.travelText().getText());
		log.debug("Getting the Travel text");
		int count=hp.linkCount().size();
		log.info("Got the count of links on Home Page");
		System.out.println(count);
		
	}
	
	@Test
	public void flightInfo() throws InterruptedException
	{
		
		Thread.sleep(2000);
	
		
		hp.departure().clear();
		hp.departure().sendKeys("new");
		log.debug("Entering the few letters of the airport name to search in departing Window");
		Thread.sleep(2000);
		
		
		//For departing Window
		int ds=hp.depatWindowList().size();
		for(int i=0; i<=ds; i++)
		{
			hp.departure().sendKeys(Keys.ARROW_DOWN);
			String dest=hp.depatWindowList().get(i).getText();
			log.debug("Getting each of the airport name from the departure displayed list");
			//System.out.println(dest);
			//Thread.sleep(2000);
			if(dest.contains("HVN - New Haven, CT"))
			{
				hp.departure().sendKeys(Keys.ENTER);
				break;
			}
		}
		
	//	System.out.println(hp.departure().getText());
		
		//For Arrival Window
			hp.arrival().click();
		  	hp.arrival().sendKeys("san");
		  	log.debug("Entering the few letters of the airport name to search in arrival Window");
			Thread.sleep(2000);
			
		
		
				int as=hp.arrivalWindowList().size();
				for(int j=0; j<=as; j++)
				{
					hp.arrival().sendKeys(Keys.ARROW_DOWN);
					String arrv=hp.arrivalWindowList().get(j).getText();
					log.debug("Getting each of the airport name from the arrival displayed list");
					
					if(arrv.contains("SJO - San Jose Juan Santamaria Intl, Costa Rica"))
					{
						
						hp.arrival().sendKeys(Keys.ENTER);
						break;
					}
				}
				
		//Selecting the number of passengers
				
				hp.passengerCount().click();
				Select s=new Select(hp.passengerCount());
				s.selectByValue("3");
				
		//Select the Departure Date
				hp.departureBox().click();
				Thread.sleep(2000);
				
				//pick common month name attribute and iterate to get the desired month 
				
				while(!hp.selectingMonth().getText().contains("October"))
				{
					hp.nextButton().click();
					log.debug("clicking on next button to see if month name matches");
				}
		
				//Grab common attribute put it on List and iterate
				
				//put all dates in one variable to know the count
				int count=hp.selectDateList().size();
			//	System.out.println(count);
				
				for(int i=0; i<count; i++)
				{
					//grab the text for each index
					String text=hp.selectDateList().get(i).getText();
					if(text.contains("24"))
					{
						hp.selectDateList().get(i).click();
						log.debug("Clicking on the desired date from the depature calendar");
						break;
					}
				}
				
				Thread.sleep(2000);
				
		//Select Return date
				hp.returnBox().click();
				
				//pick common month name attribute and iterate to get the desired month
				while(!hp.selectingMonth().getText().contains("November"))
				{
					hp.nextButton().click();
				}
				
				//Grab common attribute put it on List and iterate. made a list method
				//put all dates in one variable to know the count
				int retCount=hp.selectDateList().size();
				
				for(int j=0; j<retCount; j++)
				{
					String retText=hp.selectDateList().get(j).getText();
					if(retText.contains("4"))
					{
						hp.selectDateList().get(j).click();
						log.debug("Clicking on the desired date from the arrival calendar");
						break;
					}
				}
				Thread.sleep(2000);
			
			//Click search button
				hp.searchButton().click();
				Thread.sleep(2000);
				driver.navigate().back();
				
	}
	
	@Test
	public void travelRestChildWindow()
	{
		
		hp.travelRestriction().click();
		log.debug("Clicked on Travel Restriction Link");
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentWin=it.next();
		String childWin=it.next();
		driver.switchTo().window(childWin);
		log.info("Moved focus to child window");
		System.out.println(driver.getTitle());
		//Wantedly making the assert false by giving Freely as Free
		Assert.assertEquals(driver.getTitle(), "Sherpa – Move Free");
		log.error("Validating the title");
		driver.switchTo().window(parentWin);
		
		
		
		
	}
	
	@Test
	public void footerNavigation()
	{
	//	hp=new Homepage(driver);
		
		int count=hp.thirdColumnOfFooter().size();
		System.out.println(count);
		
		//To click each link in the first column and get page titles.
		for(int i=0; i<count; i++)
		{
			String clickOnLinks=Keys.chord(Keys.CONTROL,Keys.ENTER);
			hp.thirdColumnOfFooter().get(i).sendKeys(clickOnLinks);
			log.debug("Clicking on child windows with ctrl+ent to open in different page");
		}
		
		//to get the page titles which is opened in different windows
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentWindow=it.next();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle()); 
			
		}
		
		driver.switchTo().window(parentWindow);
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}
	

}
