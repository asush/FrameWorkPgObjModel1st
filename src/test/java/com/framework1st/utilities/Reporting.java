package com.framework1st.utilities;
//Listener Class used to to generate Extent Reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testcontext) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		String repName ="Test-Report-" + timestamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\AutomationReports\\"+repName); //specify location
		htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Sushmita");
		
		htmlReporter.config().setDocumentTitle("1st Page Object Framework Project with TestNG"); //Title of the project
		htmlReporter.config().setReportName("Automation Test Report"); //Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		}
	
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName()); //creating new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); //Sending the passed information
	}
	
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName()); //creating new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); //Sending the failed information
		
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
		
		File file = new File(screenshotPath);
		
		if(file.exists()) {
			try {
				logger.fail("Screenshot available below : " + logger.addScreenCaptureFromPath(screenshotPath));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkip (ITestResult tr) {
		logger = extent.createTest(tr.getName()); //creating new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREY)); //Sending the skipped information
	}
	
	public void onFinish(ITestContext testcontext) {
		extent.flush();
	}

}
