
package runner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Annotations {
	//int a=10; 
	//int b=20;
	 @BeforeTest	  
	  	public void beforeTest() 
	      {		 
		  System.out.println("Hi I am beforetest");
		  }
	 @AfterTest	  
	  	public void afterTest() 
	      {		 
		  System.out.println("Hi I am aftertest");
		  }
	 @BeforeClass	  
	  	public void display() 
	      {		 
		  System.out.println("Hi I am beforeclass");
		  }
	 @AfterClass	  
	  	public void show() 
	      {		 
		  System.out.println("Hi I am afterclass");
		  }
	 @BeforeMethod	  
	  	public void beforeMethod() 
	      {		 
		  System.out.println("Hi I am beforeMethod");
		  }
	 @AfterMethod	  
	  	public void AfterMethod() 
	      {		 
		  System.out.println("Hi I am afterMethod");
		  }
	 @Test(priority=-2)
	 	public void last()
	         {				  
				  System.out.println("I am Pri -2 ");				  
			  }			 
	 @Test(priority=-1)
	 @Parameters({"a"})
	 	public void check(int a)
	         {
				  if (a % 2==0)
				  {
				  System.out.println("Number "+a +" :is even");
				  }
				  else
				  {
					  System.out.println("Number "+a +" : is odd");  
				  }
			  }			
	@Test(priority=0, enabled=false)//  to skip any method
	@Parameters({"a","b"})
			public void add(int a,int b) {
				  int sum=a+b;
				  System.out.println("addition is :"+sum);
			}
	@Test(priority=1)
	@Parameters({"a","b"})
		public void subtraction(int a,int b) 
		{
			  int sub=a-b;
			  System.out.println("substraction is :"+sub);
		}
	@Test(priority=2)
	@Parameters({"a","b"})
		public void multiply(int a,int b)
	   {
			  int multi=a*b;
			  System.out.println("Multiplication value  is :"+multi);
		}
	@Test(priority=3)
	@Parameters({"a","b"})
		public void division(int a,int b) 
        {
			  int div=a % b;
			  System.out.println("division value  is :"+div);
		}

	@Test(priority=5)
	@Parameters({"a","b"})	
		public void abc(int a,int b) 
        {
			  int abc=(a+b)+(a+b);
			  System.out.println("pri 5  is :"+abc);
		}
	@Test(priority=4)
	@Parameters({"a","b"})	
		public void xyz(int a,int b) 
        {
			  int xyz=(a-b)+(a-b);
			  System.out.println("pri 4  is :"+xyz);
		}	
	@Test	
		public void first()  //
        {			  
			  System.out.println("I am in first  as per albetical order");
		}
	@Test	
	public void second()
    {
		  
		  System.out.println("I am in second  as per albetical order");
	}
	
	
	@Test(groups = { "SmokeTest"})
	public void smokeTest2()
    {
		  
		  System.out.println("I am from smoke test2");
	}
	
	@Test(groups = { "SmokeTest"})
	public void smokeTest1()
    {
		  
		  System.out.println("I am from smoke test1");
	}
	

}







