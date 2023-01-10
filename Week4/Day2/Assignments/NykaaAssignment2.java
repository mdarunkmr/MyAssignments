package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NykaaAssignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chrome = new ChromeOptions();
		chrome.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(chrome);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[text()='brands']"));
		action.moveToElement(element).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//a[contains(@href,'loreal')]")).click();
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris")) {
			System.out.println("Page title contains 'L'Oreal Paris'");
		}
		
		WebElement sortProduct = driver.findElement(By.xpath("//span[@class='sort-name']"));
		action.scrollToElement(sortProduct).pause(Duration.ofSeconds(2)).click(sortProduct).perform();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Hair']"))).click().perform();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();


		driver.findElement(By.xpath("//span[contains(text(),'Concern')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click();

		String text = driver.findElement(By.xpath("//div[@class='css-rtde4j']/div[1]/span")).getText();
		//System.out.println(text);
		if(text.equals("Shampoo")){
			System.out.println("Shampoo filter is applied");
		}

		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();

		Set<String> set = driver.getWindowHandles();

		List<String> list = new ArrayList<String>(set);

		driver.switchTo().window(list.get(1));
		Select dd = new Select(driver.findElement(By.xpath("//select[@class='css-2t5nwu']")));
		dd.selectByValue("0");
		System.out.println("MRP of the product is " + driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText());
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		String Total = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println("Grand Total Amount is "+ Total);
		driver.findElement(By.xpath("//span[contains(text(),'Proceed')]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[contains(text(),'Continue as guest')]")).click();
		driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']")).click();
		String CartTotal = driver.findElement(By.xpath("//p[@class='css-cla92e eka6zu20']")).getText();
		if(Total.equals(CartTotal)) {
			System.out.println("Grand Total & CartTotal are equal");
		}
		driver.quit();
		
	}

}
