package runner;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EvenOrOdd {

			  @Test
			  @Parameters({"a"})
			  public void check(int a) {
				  if (a % 2==0)
				  {
				  System.out.println("Number "+a +" :is even");
				  }
				  else
				  {
					  System.out.println("Number "+a +" : is odd");  
				  }
			  }
			}







