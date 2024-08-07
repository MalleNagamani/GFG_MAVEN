package implementationClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import pages.LoginPage;


public class LoginPageImpl extends LoginPage {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static ExtentSparkReporter spark;
	TakesScreenshot screenshot;
	Actions ac;
	//static screenshot;
	//public String fname;
//	public String lname;
	//public String mailid;
	public String linktitle;
	
	public LoginPageImpl(WebDriver driver,ExtentTest test){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		report=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\extentReport\\UniversityApp.html");
		report.attachReporter(spark);
		test=report.createTest("University Results");		
			this.ac=new Actions(driver);
			screenshot=(TakesScreenshot)driver;
			this.test=test;
		}
		
	
	public void clickContactPage()
	{
		Actions act=new Actions(driver);
		act.moveToElement(contact).click().build().perform();
		//contact.click();
	}
	public void enterContactDetails(String linktitle,String fname,String lname,String mailid)
	{
		Set<String> N=Nndriver.getWindowHandles();
		List<String> windowids=new ArrayList(winid);
		//System.out.println("before switching page title is : "+driver.getTitle());
		test.log(Status.PASS,"before switching page title is "  +driver.getTitle());
		test.log(Status.PASS, driver.getTitle());
		//System.out.println("total window session is : "+windowids.size());
		
		test.log(Status.PASS,"total window session are "  +windowids.size());
		for(String wids:windowids)
		{
			//System.out.println("session ids " +wids);
			test.log(Status.PASS, "session ids : " +wids);
			driver.switchTo().window(wids);	
			if(driver.getTitle().equalsIgnoreCase(linktitle))
			{
				//System.out.println("After switching page title is : "+driver.getTitle());	
				test.log(Status.PASS, "After switching page title is : " +driver.getTitle());
				firstname.sendKeys(fname);
				lastname.sendKeys(lname);
				email.sendKeys(mailid);
				submit.click();
				//System.out.println("contact page title is : "+driver.getTitle());
				test.log(Status.PASS, "contact page title is : " +driver.getTitle());
				report.flush();
	
			}else
			{
				//System.out.println("final page title is : "+driver.getTitle());
				test.log(Status.FAIL, "After switching page title is : " +driver.getTitle());
				report.flush();
			}
		
			
	}
	}
	public  void captureScreenshot(WebDriver driver,String screenshotName) 
	{
	    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		try
		{
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destination = System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShot" +  dateName + ".png";
	    FileUtils.copyFile(source, new File(destination));
	    System.out.println("Screenshot Taken");
		}catch(Exception e)
		{
			System.out.println("Exception while taking screenshot" +e.getMessage());
	    }
		//this.driver=driver;
	}





}
