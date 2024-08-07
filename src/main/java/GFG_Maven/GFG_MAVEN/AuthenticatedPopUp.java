package GFG_Maven.GFG_MAVEN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AuthenticatedPopUp {
	@BeforeTest
	public void show() {
		System.out.println("This is beforetest");
	}
	WebDriver driver=new FirefoxDriver();
	
	@Test
	public  void main() throws InterruptedException {
		
		//driver.get("http://the-internet.herokuapp.com/basic_auth");//instead of the URL need to use below append with username , password and URL
		//driver.manage().window().maximize();
		//Thread.sleep(5000);
		
		//http://Username:Password@URL
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(5000);
		System.out.println("current page titleis : "+driver.getTitle());
		driver.close();
	}
	
	@AfterTest
	public void display() {
		System.out.println("This is aftertest");
	}

}

