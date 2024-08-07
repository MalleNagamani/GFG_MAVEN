package GFG_Maven.GFG_MAVEN;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	//import org.openqa.selenium.firefox.FirefoxDriver;

	public class WindowHandles {
		@BeforeMethod
		public void show() {
			System.out.println("This is beforetest");
		}
		WebDriver driver=new ChromeDriver();
		//driver=new ChromeDriver();
		@Test
			public  void main() throws InterruptedException {				
			    
				driver.manage().window().maximize();
				driver.get("https://webdriveruniversity.com");
				//System.out.println("before switching page title is : "+driver.getTitle());					
				Thread.sleep(3000);				
				driver.findElement(By.xpath("//a[@href='Contact-Us/contactus.html']")).click();
				driver.findElement(By.xpath("//a[@id='login-portal']")).click();
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
				
	driver.close();
		}
		//driver.quit();
		
		@AfterMethod
		public void display() {
			System.out.println("This is aftertest");
		}
		}






