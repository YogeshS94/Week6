package Week6Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuplicateLead extends BaseClass{
	
	@BeforeClass
	public void getData() {
		fileName = "DuplicateLead";
	}
	
	@Test(dataProvider = "fetchData")
	public void duplicateLe(String email) throws InterruptedException {
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(email);
		
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[@class='x-btn-text' and text()='Find Leads']")).click();

		Thread.sleep(5000);
		
		WebElement firstLead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		WebElement name = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		String fName = name.getText();
		System.out.println(fName);
		firstLead.click();
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("Duplicate Lead")) {
			System.out.println("Title is: "+ title);
		}
		else {
			System.out.println("Title is wrong: "+ title);
		}
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String duplicateName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(duplicateName);
		if(fName.equals(duplicateName)) {
			System.out.println("Both names are equal");
		}
		else {
			System.out.println("Both names are not equal");
		}
	}
}
