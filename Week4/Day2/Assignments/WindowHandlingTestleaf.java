package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingTestleaf {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//following::a)[1]")).click();

		Set<String> fromContact = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(fromContact);

		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("(//table[@class='twoColumnForm']//following::a)[2]")).click();

		Set<String> toContact = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(toContact);
		driver.switchTo().window(list1.get(1));
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		driver.switchTo().window(list1.get(0));

		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		driver.switchTo().alert().accept();

		String actual = "View Contact | opentaps CRM";
		if(actual.equals(driver.getTitle())) {
			System.out.println("Page title is correct");
		}


	}

}
