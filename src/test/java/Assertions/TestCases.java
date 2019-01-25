package Assertions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases {
	

	@Test
	public void test1() {
		SoftAssert softassert = new SoftAssert();
		// create object of soft assert

		System.out.println("Open Browser");

		Assert.assertEquals(false, false);

		System.out.println("Get URL");
		System.out.println("Enter username");
		System.out.println("Enter password");
		System.out.println("click on signIn btn");

		Assert.assertEquals(true, true);

		System.out.println("Validate home page");
		softassert.assertEquals(false, true);

		System.out.println("Go to deals page");
		System.out.println("Create a deal");

		softassert.assertEquals(false, true, "Not able to create a deal");

		System.out.println("Go to contacts page");
		System.out.println("Create a contacts");

		softassert.assertEquals(false, true, "Not able to create contacts");// hard
																			// assertion
		 softassert.assertAll();
	}

	@Test
	public void test2() {
		SoftAssert softassert1 = new SoftAssert();
		System.out.println("Logout");
		softassert1.assertEquals(false, true);
		 softassert1.assertAll();
	}

//	@AfterClass
//	public void tearDown() {
//		softassert.assertAll();
//	}
}
