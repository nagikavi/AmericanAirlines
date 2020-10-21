package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivatePolicy {
	
	WebDriver driver;
	
	public PrivatePolicy(WebDriver driver)
	{
		this.driver=driver;
	}

	private By header=By.xpath("//h1[contains(text(),'Privacy policy')]");
	private By policy=By.xpath("//span[contains(text(),'Protecting your privacy')]");
	private By home=By.xpath(" //a[@id='utilityHomeLink']");
	
	public WebElement headerCheck()
	{
		 return driver.findElement(header);
	}
	
	public WebElement policyClick()
	{
		 return driver.findElement(policy);
	 
	}
	
	public WebElement homeClick()
	{
		 return driver.findElement(home);
	}

}
