package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(xpath="//a[@href='Contact-Us/contactus.html']")
	public WebElement contact;
    @FindBy(xpath="//input[@name='first_name']")
	public WebElement firstname;
    @FindBy(xpath="//input[@name='last_name']")
	public WebElement lastname;
    @FindBy(xpath="//input[@name='email']")
    public WebElement email; 
    @FindBy(xpath="//input[@value='SUBMIT']")
   	public WebElement submit;
    
    
}
