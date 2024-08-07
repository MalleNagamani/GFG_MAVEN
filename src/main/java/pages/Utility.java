package pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Calendar;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import runner.Properties;

public class Utility {
	public WebDriver driver;
	//WebDriver util;
	
	
	Actions ac;
	TakesScreenshot screenshot;
	static ExtentTest test;
	static ExtentReports report;
	static ExtentSparkReporter spark;
	
	public Utility(String Browser)
	{		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			
		}else if(Browser.equalsIgnoreCase("Firefox")){
			driver=new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("IE")){
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		//this.driver=driver;
	}
	
	public Utility(WebDriver driver,ExtentTest test)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.ac=new Actions(driver);
		screenshot=(TakesScreenshot)driver;
		this.test=test;
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	public void threadSleep(int sec)
	{
		long time=sec*1000;
		try {
			Thread.sleep(time);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
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
	
	public String readValuesfromConfig(String URL) throws IOException
	{
		//this.URL=url;
		try{
			java.util.Properties prop=new java.util.Properties();
		
		FileReader reader=new FileReader(System.getProperty("user.dir") + "\\src\\mani\\java\\TestData.Properties");
		prop.load(reader);
		prop.getProperty("URL");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return URL;
	}
}
	


	

