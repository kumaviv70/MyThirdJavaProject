import org.junit.Assert;
import org.testng.annotations.Test;



public class TestNGDependencies {
	
	@Test(priority=1)
	public void testOne() {
		System.out.println("Test 1");
		Assert.assertTrue(false);
	}
	
	@Test(priority = 2, dependsOnMethods = "testOne", alwaysRun = true)
	public void testTwo() {
		System.out.println("Test 2");
	}
	
	@Test(priority=3)
	public void testThree() {
		System.out.println("Test 3");
	}

}
