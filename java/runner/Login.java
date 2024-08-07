package runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import implementationClass.HomePageImpl;
import implementationClass.LoginPageImpl;
import pages.Utility;

public class Login {
	WebDriver driver;
	Utility util;
	//util=driver;
	
	static ExtentTest test;
	static ExtentReports report;
	static ExtentSparkReporter spark;
	//LoginPageImpl lpi=new LoginPageImpl(driver,test);
	@BeforeClass
	public void launchReport() 
	{
		report=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\extentReport\\UniversityApp.html");
		report.attachReporter(spark);
		test=report.createTest("University Results");
		//test.log(Status.PASS, "Browser launched");
	}
    
	
	
	@Test(priority=0)
	public void launchBrowser() throws IOException, InterruptedException
	    {			
		
			Utility util=new Utility("Chrome");	
			driver=util.getDriver();			
			driver.get("https://webdriveruniversity.com");
			LoginPageImpl lpi=new LoginPageImpl(driver,test);
			test.log(Status.PASS, driver.getTitle());
			//lpi.captureScreenshot(driver, "Browser launched");			
			//Thread.sleep(3000);
	    }
	//@SuppressWarnings("deprecation")
	//@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void openLoginPortal() throws InterruptedException, IOException
	{		
		//util.threadSleep(3);			
		HomePageImpl hmpg=new HomePageImpl(driver);
		hmpg.clickLoginPortal();		
		//util.threadSleep(3);
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		test.log(Status.PASS, driver.getTitle());
		if(driver.getTitle().contains("WebDriver | Contact Us"))
		{
		LoginPageImpl lpi=new LoginPageImpl(driver,test);
		//lpi.captureScreenshot(driver, "Login Portal launched");
		}	
	}
	@Test(priority=2)
    public void openContact() throws InterruptedException, IOException
    {
		  
		//Boolean result = null;
			LoginPageImpl lpi=new LoginPageImpl(driver,test);
			lpi.clickContactPage();
			//util.threadSleep(3);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			test.log(Status.PASS, driver.getTitle());	
			//lpi.captureScreenshot(driver, "Contact Page launched");
			lpi.enterContactDetails("WebDriver | Contact Us","NagaMani", "Malle", "nagamani.malle@gmail.com");
			if(driver.getTitle().contains("WebDriver | Contact Us")) {
			//lpi.captureScreenshot(driver, "Contact Page filled with data");		
			}
    }
	@AfterMethod
	public void takeScreenshot(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			LoginPageImpl lpi=new LoginPageImpl(driver,test);
			lpi.captureScreenshot(driver, result.getName());
		}
	}
	@AfterClass
	public void closeBrowser() 
	{
		 
		driver.quit();
		report.flush();
	}

	

}
