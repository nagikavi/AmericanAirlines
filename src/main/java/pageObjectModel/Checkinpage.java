package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkinpage {
	
	WebDriver driver;
		
	public Checkinpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By fn=By.id("findReservationForm.firstName");
	private By ln=By.id("findReservationForm.lastName");
	private By confirmationNum=By.id("findReservationForm.recordLocator");
	private By ticketNum=By.id("findReservationForm.ticketNumber");
	private By find=By.id("findReservationForm.submit");
	private By errorMess=By.id("findReservationForm.globalErrorsHeader");
	private By header=By.cssSelector("h1[class='aa-pageTitle']");
	
	public WebElement firstName()
	{
		return driver.findElement(fn);
	}
	
	public WebElement lastName()
	{
		return driver.findElement(ln);
	}
	
	public WebElement confirmationNumber()
	{
		return driver.findElement(confirmationNum);
	}
	
	public WebElement ticketNumber()
	{
		return driver.findElement(ticketNum);
	}
	
	public WebElement findButton()
	{
		return driver.findElement(find);
	}
	
	public WebElement errorMessage()
	{
		return driver.findElement(errorMess);
	}

	public WebElement headerMessage()
	{
		return driver.findElement(header);
	}
}
