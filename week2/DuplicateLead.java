package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Leads')])[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("vishu123@mail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(1000);
		WebElement leadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String text = leadId.getText();
		System.out.println(text);
		Thread.sleep(3000);
		leadId.click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(2000);
		String actualName = driver.findElement(By.xpath("//span[text()='First name']/following::input[1]")).getAttribute("value");
		//System.out.println(actualName);
		String actualTitle = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		//System.out.println(actualTitle);
		String expectedTitle = "Duplicate Lead";
		if (expectedTitle.equals(actualTitle))
		{ 
			System.out.println("Title is correct");
		}else{
			System.out.println("Title is wrong");
		}
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(2000);
		String expectedName = driver.findElement(By.xpath("//span[text()='First name']/following::span[1]")).getText();
		//System.out.println(expectedName);
		if (actualName.equalsIgnoreCase(expectedName))
		{ 
			System.out.println("Name is correct");
		}else{
			System.out.println("Name is wrong");
		}
		//driver.close();

	}

}
