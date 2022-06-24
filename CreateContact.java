package Week6Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateContact extends BaseClass {
	@Test(dataProvider = "dataProvid")
	public void createCont(String fname, String lname) {
		
//		// Driver setup
//		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\60028440\\\\Documents\\\\TestLeaf\\\\Webdriver\\\\chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
//		
//		// Setting up the URL
//		driver.get("http://leaftaps.com/opentaps/control/login");
//		driver.manage().window().maximize();
//		
//		//Entering the username and password to login
//		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
//		driver.findElement(By.id("password")).sendKeys("crmsfa");
//		driver.findElement(By.className("decorativeSubmit")).click();
//		
//		//Clicking Create Contact button in contact page
//		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Enter the required fields
		driver.findElement(By.id("firstNameField")).sendKeys(fname);
		driver.findElement(By.id("lastNameField")).sendKeys(lname);
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Aadhi");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Yogu");
		driver.findElement(By.name("departmentName")).sendKeys("Searching");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("Write the description");
		driver.findElement(By.xpath("(//input[@name='primaryEmail'])[4]")).sendKeys("yogeshvasan94@gmail.com");
		
		// Selecting the state from dropdown
		WebElement state = driver.findElement(By.xpath("//select[@id='createContactForm_generalStateProvinceGeoId']"));
		Select dropS = new Select(state);
		dropS.selectByVisibleText("New York");

		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		
		//Press edit button to edit some fields
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Enter the important note");
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		System.out.println(driver.getTitle()+"===================");
		
	}
	
	@DataProvider
	public String[][] dataProvid() {
		String[][] data = new String[2][2];
		data[0][0] = "Aadhiya";
		data[0][1] = "Yogi";
		
		data[1][0] = "Veera";
		data[1][1] = "Yogu";
		return data;
	}
}
