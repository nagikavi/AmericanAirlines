package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Travelinformationpage {

	WebDriver driver;
	
	public Travelinformationpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By travTempId=By.id("manage");
	private By travTempIdLinks=By.xpath("//div[@id='manage']//a");
	private By linkPlanes=By.xpath("//div[@id='manage']//a[text()='Planes']");
	private By checkIn=By.linkText("Check in");
	

public WebElement travelTemplateId()
{
	return driver.findElement(travTempId);
}

public List<WebElement> travelTemplateIdLinks()
{
	return driver.findElements(travTempIdLinks);
}

public Travelplanespage clickPlaneLink()
{
	 driver.findElement(linkPlanes).click();
	 Travelplanespage tpp= new Travelplanespage(driver);
	 return tpp;
}

public Checkinpage checkInLink()
{
	 driver.findElement(checkIn).click();
	 Checkinpage cp= new Checkinpage(driver);
	 return cp;
}

}
