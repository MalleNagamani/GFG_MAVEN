package runner;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sub {
	
	  @Test
	  @Parameters({"a","b"})
	  public void minus(int a,int b) {
		  int sub=a-b;
		  System.out.println("substraction is :"+sub);
	  }
	}


