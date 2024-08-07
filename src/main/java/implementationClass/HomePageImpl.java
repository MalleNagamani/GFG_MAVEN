package implementationClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;

public class HomePageImpl extends HomePage {
	WebDriver driver;
	
	public HomePageImpl(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	public void clickLoginPortal()
	{
		Actions act=new Actions(driver);
		act.moveToElement(login).click().build().perform();
		//login.click();
	}

	
}
