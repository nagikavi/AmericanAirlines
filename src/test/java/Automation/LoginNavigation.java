package Automation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModel.Homepage;
import pageObjectModel.Loginpage;
import pageObjectModel.PrivatePolicy;
import pageObjectModel.TermsAndConditions;
import resources.Base;

public class LoginNavigation extends Base {
	
	WebDriver driver;
	Homepage hp;
	Loginpage lp;
	
	private static Logger log=LogManager.getLogger(LoginNavigation.class.getName());
	
	@BeforeClass
	public void initializesDriver() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		hp=new Homepage(driver);
			
		
	}
	
	@Test(dataProvider="loginInfo")
	public void login(String AAd,String LN, String Passwd) throws InterruptedException 
	{
		Loginpage lp=hp.logIn();
		lp.aaAdvantageBox().sendKeys(AAd);
		log.debug("Entered in the AA advantage box");
		lp.lastNameBox().sendKeys(LN);
		log.debug("Entered in the Last Name box");
		lp.passwordBox().sendKeys(Passwd);
		log.debug("Entered in the Password box");
		lp.loginButton().click();
		log.debug("CLicked the login button");
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] loginInfo()
	{
		Object[][] info=new Object[1][3];
		
		info[0][0]="ashnbel";
		info[0][1]="reddy";
		info[0][2]="1828he";
		
		return info;
		
	}
	
	@Test(enabled=false)
	public void termsAndCondNavigation() throws InterruptedException
	{
		Loginpage lp=hp.logIn();
		TermsAndConditions tc=lp.termsAndConditions();
		System.out.println(driver.getTitle());
		Set<String> s=driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		String parentWind=it.next();
		String childWind=it.next();
		driver.switchTo().window(childWind);
		System.out.println(driver.getTitle());
		Assert.assertEquals(tc.headerCheck().getText(), "AAdvantage terms and conditions");
		driver.close();
		driver.switchTo().window(parentWind);
	}
	
	@Test
	public void privatePolicyNavigation() throws InterruptedException
	{
		Loginpage lp=hp.logIn();
		Thread.sleep(1000);
		PrivatePolicy pp=lp.privacyPolicy();
		Set<String> s=driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		String parentWind=it.next();
		String childWind=it.next();
		driver.switchTo().window(childWind);
		System.out.println(driver.getTitle());
		System.out.println(pp.headerCheck().getText());
		pp.homeClick().click();
		driver.close();
		driver.switchTo().window(parentWind);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		
	}
}
