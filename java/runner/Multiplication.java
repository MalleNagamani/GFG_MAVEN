package runner;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Multiplication {
	

		  @Test
		  @Parameters({"a","b"})
		  public void multiply(int a,int b) {
			  int multi=a*b;
			  System.out.println("Multiplication value  is :"+multi);
		  }
		}




