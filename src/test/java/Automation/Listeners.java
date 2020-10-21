package Automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReportNG;

public class Listeners extends Base implements ITestListener{

	ExtentTest test;
	//calling the method from resource ExtentReportNG class
	ExtentReports extent=ExtentReportNG.getReportObject();
	//To make the Extent Report thread safe while executing parallel tests we need to use ThreadLocal java
	//class
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=extent.createTest(result.getMethod().getMethodName());
		//Now set the test inside extentTest then it will keep all the new test object created by testcases 
		 //Thread safe
		 extentTest.set(test);
		 
		 
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//We want to log to the report whenever a test case is passed by attaching the log to test object 
		extentTest.get().log(Status.PASS, "Test got Passed");
		System.out.println("I passed Successfully" +result.getName());
		
	}	

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//We want to log to the report whenever a test case is failed by attaching the log to test object 
		//failure log will be retrieved by getThrowable() method and prints all the test case names
		//in the report. 
		
		//get back the test object whenever we want from extentTest
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver=null;
		//The below sentence with fetch the failed test method name
		String testMethodName=result.getMethod().getMethodName();
		
		//To get access to any fields of any class using testNg listener then need to type
		//below. String result will have the method which failed
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) 
		{
		}
		
		try {
			//the below line will captures screen shot and attach it to the failed test case page in 
			//Extent Report
			extentTest.get().addScreenCaptureFromPath(getScreenShot(testMethodName,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
