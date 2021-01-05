package redbus;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class listeners extends base implements ITestListener {
	ExtentReports extent=extentreport.config();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		 test=extent.createTest(result.getMethod().getMethodName());
		 
		 extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed");
		WebDriver driver=null;
		String testcasemethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch(Exception e)
		{
		
		}
		try{
			extentTest.get().addScreenCaptureFromPath(getscreenshot(testcasemethodname,driver), result.getMethod().getMethodName());
			
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
	
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testcasemethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch(Exception e)
		{
		
		}
		try{
			extentTest.get().addScreenCaptureFromPath(getscreenshot(testcasemethodname,driver), result.getMethod().getMethodName());
			
		}
		catch(IOException e){
			e.printStackTrace();
			
		}

	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	
	}

}
