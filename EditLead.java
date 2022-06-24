package Week6Day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditLead extends BaseClass {
	
	@BeforeClass
	public void getData() {
		fileName = "EditLead";
	}
	
	@Test(dataProvider="fetchData", priority = 2)
	public void editLe(String companyN, String changeCompany) throws InterruptedException {
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		// Edit the Company number and check whether its updated or not
		
		driver.findElement(By.xpath("(//input[@name='firstName' and @class=' x-form-text x-form-field'])[3]")).sendKeys(companyN);
		
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[@class='x-btn-text' and text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		WebElement firstLead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		firstLead.click();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		String changeName = changeCompany;
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(changeName);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Update']")).click();
		
		String changedText = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println("Updated Company Name: "+changedText);
		if(changedText.contains(changeName)){
			System.out.println("Successful");
		}
		else {
			System.out.println("Not Successful");
		}	
	}
}
