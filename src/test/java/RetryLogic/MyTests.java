package RetryLogic;

import org.testng.Assert;
import org.testng.annotations.Test;

import Analyzer.RetryAnalyzer;


public class MyTests {
	
	@Test()
	public void Test1()
	{
		Assert.assertEquals(false, true);
	}	
 
	@Test()
	public void Test2()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test(enabled=false)
	public void Test3()
	{
		Assert.assertEquals(true, true);
	}
	
	

}
