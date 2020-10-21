package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
	
	prop=new Properties();
	//System.getProperty("user.dir") this gives the path till the project from their local system.
	
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	
	//The below code is to read from data.properties file
	String browsername=prop.getProperty("browser");
	
	//To run the browser option from the command prompt in maven we need to write the below line
	//System is to get from command prompt.So that anyone can select the browser from cmd prompt
	//mvn test -Dbrowser=chrome
	//String browsername=System.getProperty("browser");
	
	if(browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			//to run in headless mode need to use ChromeOptions class.As people don't want to see the 
			//browsers while running the tests so we use headless mode.
			ChromeOptions options=new ChromeOptions();
			
			if(browsername.contains("headless"))
			{
				options.addArguments("headless");
			}
				driver=new ChromeDriver(options);
		}
	else if(browsername.contains("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"");
	}
	else if(browsername.contains("IE"))
	{
		System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"");
		driver=new InternetExplorerDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	public String getScreenShot(String testMethodName,WebDriver driver) throws IOException
	{
				
		//Took a screenshot and stored it in a virtua file. Now need to bring it to our local machine
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//We will print the screen shot inside the project with failed testcase name
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+ testMethodName+".png";
		
		//Bringing to the local machine with the following code
		FileUtils.copyFile(source, new File(destinationFile));
		
		//Returning the path where the screen shot is stored in our local machine so we can pass
		//it to extentTest addScreenShotFromPath() method as first argument so it shows the screen shot
		//in extent report when a test case is failed.
		return destinationFile;
	}
}
