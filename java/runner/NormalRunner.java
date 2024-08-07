package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NormalRunner {
	WebDriver driver=new ChromeDriver();
	@BeforeTest
     public void beforeTe()
     {
		driver.manage().window().maximize();
     }
		
	@Test(priority=1)
	public  static void main() throws InterruptedException {	
			driver.get("https://webdriveruniversity.com");
			//System.out.println("before switching page title is : "+driver.getTitle());					
			Thread.sleep(3000);				
			//Click on WebElement through Actions
			WebElement  contact=driver.findElement(By.xpath("//a[@href='Contact-Us/contactus.html']"));
			Actions act=new Actions(driver);
			act.moveToElement(contact).click().build().perform();
			WebElement  login=driver.findElement(By.xpath("//a[@id='login-portal']"));
			//Actions act1=new Actions(driver);
			act.moveToElement(login).click().build().perform();
			
			Thread.sleep(3000);
			Set<String> winid=driver.getWindowHandles();
			List<String> windowids=new ArrayList(winid);
			System.out.println("before switching page title is : "+driver.getTitle());
			System.out.println("total window session is : "+windowids.size());
			for(String wids:windowids)
			{
				System.out.println("session ids " +wids);
				driver.switchTo().window(wids);
				System.out.println("After switching page title is : "+driver.getTitle());
				if(driver.getTitle().equalsIgnoreCase("WebDriver | Contact Us"))
						
				{
					driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Nagamani");
					driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Malle");
					driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Nagamani.Malle@gmail.com");
					driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
					System.out.println("contact page title is : "+driver.getTitle());
			}
				
				
		}
			
			
	}
	@AfterTest
    public void afterTe()
    {		
   driver.quit();
	}



}
