package runner;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sum {
  @Test
  @Parameters({"a","b"})
  public void add(int a,int b) {
	  int sum=a+b;
	  System.out.println("addition is :"+sum);
  }
}
