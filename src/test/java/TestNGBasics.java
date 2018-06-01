import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGBasics {

@BeforeMethod
public void test()
{
	System.out.println("test");
}

@Test
public void test1(){
	System.out.println("test1");
}

@AfterMethod
public void test2()
{
	System.out.println("test2");
}

}


