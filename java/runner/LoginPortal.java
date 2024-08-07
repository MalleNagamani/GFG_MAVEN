package runner;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import org.openqa.selenium.io.FileHandler;
import java.util.Date;

import implementationClass.HomePageImpl;
import implementationClass.LoginPageImpl;
import pages.Utility;

public class LoginPortal {
	WebDriver driver;
	Utility util;
	static ExtentTest test;
	static ExtentReports report;
	static ExtentSparkReporter spark;
	
	//driver=util.getDriver();
		@BeforeClass
		public void launchBrowser() throws IOException
		    {			
				report=new ExtentReports();
				spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\extentReport\\UniversityApp.html");
				report.attachReporter(spark);
				test=report.createTest("University Results");
				Utility util=new Utility("Chrome");
				driver=util.getDriver();				
				test.log(Status.PASS, "Browser launched");
				//util.takeScreenshot();
		    }
		@Test(priority=0)
		public void openApplication() throws InterruptedException, IOException
		{
			driver.get("https://webdriveruniversity.com");
			//System.out.println("Intial page title is : "+driver.getTitle());
			test.log(Status.PASS, driver.getTitle());
			//util.threadSleep(3);
			Thread.sleep(3000);	
			HomePageImpl hmpg=new HomePageImpl(driver);
			hmpg.clickLoginPortal();
			
			//util.threadSleep(3);
			Thread.sleep(3000);	
			test.log(Status.PASS, driver.getTitle());
			Assert.assertFalse(driver.getTitle().contains("WebDriver | Contact Us"));
			
		}
		@Test(priority=1)
        public void openContact() throws InterruptedException, IOException
        {
			  
			//Boolean result = null;
				LoginPageImpl lpi=new LoginPageImpl(driver,test);
				lpi.clickContactPage();
				//util.threadSleep(3);
				Thread.sleep(3000);	
				test.log(Status.PASS, driver.getTitle());
				//Utility ut=new Utility(driver,test);				
				lpi.enterContactDetails("WebDriver | Contact Us","NagaMani", "Malle", "nagamani.malle@gmail.com");
				Assert.assertFalse(driver.getTitle().contains("WebDriver | Contact Us"));
				//assertTrue
				//if(driver.getTitle().equalsIgnoreCase("WebDriver | Contact Us") || driver.getTitle().equalsIgnoreCase("WebDriver | Login Portal ")) {
		         // String Sshot=lpi.TakeScreenshot();
		           // test.log(Status.PASS, Sshot);
		           // File source = lpi.setScreenshotAs(OutputType.FILE);
		            // Sshot = System.setProperty(("user.dir") + "\\src\\test\\resources\\ScreenShot"  + ".png", "PASS");
		           // String desti = System.setProperty(lpi.TakeScreenshot(), Sshot);	
		           // File finalDesti = new File(lpi.TakeScreenshot());
				 //   FileHandler.copy(lpi.TakeScreenshot(), finalDesti);
				    //return destin;
		           // (util.driver).setAttribute("\\src\\test\\resources\\ScreenShot", takeScreenshot); //sets the value the variable/attribute screenshotPath as the path of the sceenshot
		        //}
				//return result;

				
        }
		//LoginPortal lp=new LoginPortal(); 
		@AfterMethod
		
		public void setScreenShotPath() throws IOException, InterruptedException
		{
			//Boolean result=FALSE;
			
			//result=lp.openContact();
			String path = null;
			//if(result.FALSE)
			LoginPageImpl lpi=new LoginPageImpl(driver,test);
			lpi.captureScreenshot(driver, "Portal launched");
					//.TakeScreenshot(driver);
			//String destination = util.TakeScreenshot(driver);
			test.log(Status.FAIL,"contact page not updated");
			path = System.setProperty(("user.dir")+ "\\src\\test\\resources\\ScreenShot" +".png",("user.dir") + "\\src\\test\\resources\\extentReport\\UniversityApp.html");
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			//test.fail(result.booleanValue(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			//report.flush();
			//test.addScreenCaptureFromPath(path)
		}
		@AfterClass
		public void closeBrowser() 
		{
			 
			driver.quit();
			report.flush();
		}
		
}
