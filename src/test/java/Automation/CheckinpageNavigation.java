package Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.Checkinpage;
import pageObjectModel.Homepage;
import pageObjectModel.Travelinformationpage;
import resources.Base;

public class CheckinpageNavigation extends Base{

	WebDriver driver;
	Homepage hp;
	Travelinformationpage tp;
	Checkinpage cp;
	public static Logger log=LogManager.getLogger(CheckinpageNavigation.class.getName());
	
	
	@BeforeTest(groups = {"regression"})
	public void initializesDriver() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		hp=new Homepage(driver);
		
	}
	
	@Test(groups = {"regression"})
	public void checkInInfo() throws InterruptedException
	{
		//hp=new Homepage(driver);
		Travelinformationpage tp=hp.travelInfo();
		//tp=new Travelinformationpage(driver);
		Checkinpage cp=tp.checkInLink();
		//cp=new Checkinpage(driver);
		Thread.sleep(2000);
		cp.firstName().sendKeys("jdkdhenj");
		log.debug("Enetering the First Name of the passenger");
		cp.lastName().sendKeys("heloo");
		log.debug("Enetering the Last Name of the passenger");
		cp.confirmationNumber().sendKeys(Keys.SHIFT);
		cp.confirmationNumber().sendKeys("sdhksdjlkfj");
		log.debug("Enetering the Confirmation number of the passenger");
		cp.ticketNumber().sendKeys("2738390303765");
		log.debug("Enetering the Ticket number of the passenger");
		cp.findButton().click();
		log.debug("Clicking the Find button");
		System.out.println(cp.errorMessage().getText());
		
		
	}
	
	@Test(groups = {"regression"})
	public void headerPrint()
	{
		//hp=new Homepage(driver);
		Travelinformationpage tp=hp.travelInfo();
		log.debug("Clicked the travel information tab");
		
		//tp=new Travelinformationpage(driver);
		Checkinpage cp=tp.checkInLink();
		log.debug("Clicked the check in link from travel information tab");
		
		//cp=new Checkinpage(driver);
		System.out.println(cp.headerMessage().getText());
		log.debug("Getting the header message from the Check In page");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
	
}
