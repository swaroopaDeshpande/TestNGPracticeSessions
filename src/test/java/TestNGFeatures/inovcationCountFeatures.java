package TestNGFeatures;

import org.testng.annotations.Test;

public class inovcationCountFeatures {
	
	//same test case again and again
	
	@Test(invocationCount=5)
	public void repetedTestCase()
	{
		System.out.println("Test");
	}
	
	@Test(timeOut=10)
	public void repetedTestCase1()
	{
		System.out.println("Test");
	}

		
}
