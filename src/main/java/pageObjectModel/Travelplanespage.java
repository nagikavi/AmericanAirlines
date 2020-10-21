package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Travelplanespage {
	
	WebDriver driver;
	
	public Travelplanespage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By frameId=By.id("aa-content-frame");
	private By modelSelect=By.cssSelector("section[class='section']");
	private By airbusA319Rows=By.xpath("//div[@id='a319']//table//tbody//tr");
	private By airbusTwo=By.xpath("//div[@id='a319']//table[2]//tbody//tr");
	
	public WebElement wholeFrameId()
	{
		return driver.findElement(frameId);
	}
	
	public List<WebElement> flightModel()
	{
		return driver.findElements(modelSelect);
	}
	
	public List<WebElement> versionOneTable()
	{
		return driver.findElements(airbusA319Rows);
	}

}
