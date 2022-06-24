package Week6Day2;

import org.testng.annotations.Test;

public class PractiseAttributes {
	
	@Test
	public void One() {
		System.out.println("One");
	}
	
	@Test(priority = 2)
	public void Two() {
		System.out.println("Two");
	}
	
	@Test(priority = 0, invocationCount = 4)
	public void Three() {
		System.out.println("Three");
	}
	
	@Test(dependsOnMethods = {"Two"})
	public void Four() {
		System.out.println("Four");
	}
}
