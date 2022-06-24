package Week6Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{
	@BeforeClass
	public void getData() {
		fileName = "CreateLead";
	}
	
	
	@Test(dataProvider="fetchData", priority = 1)
	public void createLe(String company, String fName, String lName, String lFName, String dep, String descrip, String email, String stateN) {
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		
		driver.findElement(By.xpath("//input[contains(@id,'companyName')]")).sendKeys(company);
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(fName);
		
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys(lName);
		
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys(lFName);
		
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys(dep);
		System.out.println(dep);
		
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(descrip);
		System.out.println(descrip);
		
		driver.findElement(By.xpath("(//input[@name='primaryEmail'])[4]")).sendKeys(email);
		System.out.println(email);
		
		WebElement state = driver.findElement(By.xpath("//select[contains(@name,'StateProvince')]"));
		
		Select dd = new Select(state);
		
		dd.selectByVisibleText(stateN);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
}