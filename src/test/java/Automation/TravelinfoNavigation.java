package Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.Checkinpage;
import pageObjectModel.Homepage;
import pageObjectModel.Travelinformationpage;
import pageObjectModel.Travelplanespage;
import resources.Base;

public class TravelinfoNavigation extends Base {

	WebDriver driver;
	Homepage hp;
	Travelinformationpage tp;
	
	public static Logger log=LogManager.getLogger(TravelinfoNavigation.class.getName());
	
	@BeforeTest(groups = {"regression"})
	public void initializesDriver() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		hp=new Homepage(driver);
	}
	
	@Test(groups= {"regression"})
	public void numOfTravelLinks()
	{
		
		Travelinformationpage tp=hp.travelInfo();
		
		int count=tp.travelTemplateIdLinks().size();
		log.debug("Counting the number of links in the travel window");
		System.out.println(count);
		
		
	}
	
	@Test
	public void planesLinkNavigation() throws InterruptedException
	{
		
		Travelinformationpage tp=hp.travelInfo();
		 Travelplanespage tpp=tp.clickPlaneLink();
		 Thread.sleep(2000);
		log.info("Clicked on the Planes link from Travel Informstion Window");
	}
	
	@Test
	public void checkInNavigation() throws InterruptedException
	{
		Travelinformationpage tp=hp.travelInfo();
		Thread.sleep(2000);
		Checkinpage cp=tp.checkInLink();
		log.info("Clicked on the CheckIn link from Travel Informstion Window");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}
	
}
