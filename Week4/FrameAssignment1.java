package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameAssignment1 {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[text()='Topic :']/following::input")).sendKeys("Arun");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		Select ddAnimals = new Select(driver.findElement(By.id("animals")));
		ddAnimals.selectByVisibleText("Avatar");
		
	}

}
