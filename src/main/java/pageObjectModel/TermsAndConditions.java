package pageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TermsAndConditions {
	
WebDriver driver;
	
	public TermsAndConditions(WebDriver driver)
	{
		this.driver=driver;
	}

	private By header=By.xpath("//h1[contains(text(),'AAdvantage terms and conditions')]");
	
	public WebElement headerCheck()
	{
		return driver.findElement(header);
	}
	
	
	

}
