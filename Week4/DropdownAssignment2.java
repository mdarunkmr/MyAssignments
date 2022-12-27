package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/select.xhtml;jsessionid=node01b6hhw7csjf211q4hnvqtdlyg710515.node0");
		Select ddTool = new Select(driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")));
		ddTool.selectByVisibleText("Selenium");
		driver.findElement(By.xpath("//label[@id='j_idt87:country_label']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'India')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@id='j_idt87:city_label']")).click();
		driver.findElement(By.xpath("//li[contains(text(),'Chennai')]")).click();
		driver.findElement(By.xpath("//button[@class='ui-autocomplete-dropdown ui-button ui-widget ui-state-default ui-corner-right ui-button-icon-only']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(text(),'Selenium WebDriver')]")).click();
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(text(),'Tamil')]")).click();
		Thread.sleep(2000);
		WebElement choose = driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-triangle-1-s ui-c'])[4]"));
		driver.executeScript("arguments[0].click()", choose);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(text(),'One')]")).click();

	}

}
