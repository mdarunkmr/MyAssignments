package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceNowAssignment4 {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://dev110326.service-now.com/");
        driver.switchTo().frame("gsft_main");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("India@123");
        driver.findElement(By.id("sysverb_login")).click();
	}

}
