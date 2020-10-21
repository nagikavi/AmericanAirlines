package Automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectModel.Homepage;
import pageObjectModel.Travelinformationpage;
import pageObjectModel.Travelplanespage;
import resources.Base;

public class TravelplanesNavigation extends Base {

	WebDriver driver;
	Homepage hp;
	Travelinformationpage tp;
	Travelplanespage tpp;
	public static Logger log=LogManager.getLogger(TravelplanesNavigation.class.getName());
	
	@BeforeTest(groups = {"regression"})
	public void initializesDriver() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	
	//@Test(dependsOnMethods= {"initializesDriver"})
	@Test(groups= {"regression"})
	public void printingTableRecord()
	{
		hp=new Homepage(driver);
		Travelinformationpage tp=hp.travelInfo();
		Travelplanespage tpp=tp.clickPlaneLink();
		log.info("Clicked on the Planes link in Travel Information window");
		//tpp=new Travelplanespage(driver);
		int count = tpp.versionOneTable().size();
		log.debug("Getting Number of rows in the first table");
		System.out.println(count);
		
		//Get all the records of the first version
		for(int i=0; i<count; i++)
		{
			System.out.print(tpp.versionOneTable().get(i).getText());
			log.debug("Getting all the rows from the first table");
		}
		
	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		
	}
	
}
