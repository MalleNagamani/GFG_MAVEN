package runner;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
//import org.testng.asserts.Assertion;

//import com.aventstack.extentreports.util.Assert;

public class AnnotationsWithSuite {
	@Test(groups = { "SmokeTest"})
	public void smokeTest4()
    {
		  
		  System.out.println("I am from smoke test4");
	}
	
	 @BeforeSuite	  
	  	public void display() 
	      {		 
		  System.out.println("Hi I am beforesuite");
		  }
	 @AfterSuite	  
	  	public void show() 
	      {		 
		  System.out.println("Hi I am aftersuite");
		  }
	 
	 @Test(groups = { "SmokeTest"})
		public void smokeTest3()
	    {
			  
			  System.out.println("I am from smoke test3");
		}
	
		
}
