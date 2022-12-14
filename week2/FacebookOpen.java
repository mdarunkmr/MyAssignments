package week2.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookOpen {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Arun Kumar");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Deveraj");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("1234567890");
		driver.findElement(By.id("password_step_input")).sendKeys("Password@123");
		Select dddate = new Select(driver.findElement(By.id("day")));
		dddate.selectByVisibleText("25");
		Select ddmonth = new Select(driver.findElement(By.id("month")));
		ddmonth.selectByVisibleText("Feb");
		Select ddyear = new Select(driver.findElement(By.id("year")));
		ddyear.selectByVisibleText("1984");
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();


	}

}
