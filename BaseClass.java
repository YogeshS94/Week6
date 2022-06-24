package Week6Day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import Week6Day2.ReadData;

public class BaseClass {
	
	public ChromeDriver driver;
	public String fileName;
	
	@Parameters({"url", "username", "password"})
	@BeforeMethod
	public void preCondition(String url, String userN, String Pass) {
		// Driver setup
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\60028440\\\\Documents\\\\TestLeaf\\\\Webdriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Setting up the URL
		driver.get(url);
		driver.manage().window().maximize();
		
		//Entering the username and password to login
		driver.findElement(By.id("username")).sendKeys(userN);
		driver.findElement(By.id("password")).sendKeys(Pass);
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Clicking Create Contact button in contact page
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	
	@DataProvider(name = "fetchData")
	public String[][] fetchData() throws IOException {
		return ReadData.fetchData(fileName);
	}
}
