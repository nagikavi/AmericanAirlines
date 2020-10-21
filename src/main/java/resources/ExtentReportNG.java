package resources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	 static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		
		//To configure the code we need ExtentSparkReporter class object
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//extent report is the main class we require
		extent=new ExtentReports();
		//Attach the config file to the main report
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kavitha");
		return extent;
	}

}
