package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyValueAssignment3 {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://buythevalue.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='owl-item active']")).click();
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//div[@class='VizExIcon__IconWrapper-sc-13xmv9w-0 kLdQSk']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("wk_zipcode")).sendKeys("600100");
		WebElement a = driver.findElement(By.xpath("//input[@class='btn']"));
		driver.executeScript("arguments[0].click();", a);
		Thread.sleep(2000);
		driver.findElement(By.id("product-add-to-cart")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'View Cart')])[2]")).click();
		driver.findElement(By.id("checkout")).click();
		driver.switchTo().alert().accept();
	}


}
