package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By aad=By.id("loginId");
	private By lastN=By.id("lastName");
	private By pass=By.id("password");
	private By loginB=By.id("button_login");
	private By close=By.xpath("//button[@id='loginMainErrorMsgDialogButton0']//span[@class='ui-button-text']");
	private By pPolicy=By.xpath("//a[contains(text(),'American Airlines privacy policy')]");
	private By termsCond=By.xpath("//section[@class='section text-left']/p/a[2]");
	
	public WebElement aaAdvantageBox()
	{
		return driver.findElement(aad);
	}
	
	public WebElement lastNameBox()
	{
		return driver.findElement(lastN);
	}
	
	public WebElement passwordBox()
	{
		return driver.findElement(pass);
	}
	
	public WebElement loginButton()
	{
		return driver.findElement(loginB);
	}
	
	public WebElement closeButton()
	{
		return driver.findElement(close);
	}
	
	public PrivatePolicy privacyPolicy()
	{
		driver.findElement(pPolicy).click();
		PrivatePolicy pp=new PrivatePolicy(driver);
		return pp;
	}
	
	public TermsAndConditions termsAndConditions()
	{
		driver.findElement(termsCond).click();
		TermsAndConditions tc=new TermsAndConditions(driver);
		return tc;
		
	}
}
