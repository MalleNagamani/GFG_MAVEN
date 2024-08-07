package runner;

import org.testng.Assert;
//import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AnnotationsDifferent {
	 @Test
	    public void testCase2(){
	       // System.out.println("in test case 2");
	        Assert.assertEquals("Mani","Mani");
	    }

	    @Test(dependsOnMethods = { "testCase2" })
	    public void testcase3(){
	        System.out.println("OK");
	    }

	    @Test(alwaysRun = true)    //even it written false it will execute irrespective of result
	    public void testcase4() {
	        System.out.println("in testcase4");
	        Assert.assertEquals("abc","abc");
	    }

}
