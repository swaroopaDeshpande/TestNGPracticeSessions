package TestNGFeatures;

import org.testng.annotations.Test;

public class enabledConcept {

	@Test(enabled = false)
	public void TestEnabled1() {
		System.out.println("Enabled");
	}

	@Test(enabled = true)
	public void TestEnabled2() {
		System.out.println("Enabled");
	}

	@Test(enabled = false)
	public void TestEnabled3() {
		System.out.println("Enabled");
	}

	@Test(enabled = true)
	public void TestEnabled4() {
		System.out.println("Enabled");
	}

	@Test(enabled = false)
	public void TestEnabled5() {
		System.out.println("Enabled");
	}

}
