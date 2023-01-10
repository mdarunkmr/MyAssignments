package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapdealAssignment3 {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.snapdeal.com/");

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//li[@navindex='1']"))).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		String productCount = text.replaceAll("[^0-9]","");
		System.out.println("Total Sports shoes count is "+ productCount);
		driver.findElement(By.xpath("//div[text() ='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype= 'plth']")).click();
		Thread.sleep(3000);

		List<WebElement> price= driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price)
		{
			prices.add(e.getText().replaceAll("[^0-9]",""));    
		}
		List<String> sortedPrices = new ArrayList<String>(prices);
		Arrays.parallelSort(sortedPrices.toArray(new String[sortedPrices.size()]));
		Thread.sleep(2000);
		//System.out.println(sortedPrices);
		//System.out.println(prices);
		if (sortedPrices.equals(prices)) {
			System.out.println("Prices are sorted correctly");
		}

		WebElement rangeFrom = driver.findElement(By.name("fromVal"));
		rangeFrom.clear();
		rangeFrom.sendKeys("900");
		WebElement rangeTo = driver.findElement(By.name("toVal"));
		rangeTo.clear();
		rangeTo.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		driver.findElement(By.xpath("//button[text() ='Clear All ']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		String filter = driver.findElement(By.xpath("//a[contains(text(),' Navy')]")).getText();
		//System.out.println(filter);
		if(filter.equals("Navy"))
		{
			System.out.println("Navy colour filter applied");
		}

		WebElement mouseHover = driver.findElement(By.xpath("//p[@class='product-title']"));
		builder.moveToElement(mouseHover).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();

		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Shoe cost is Rs. "+cost);
		Thread.sleep(2000);
		String percentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount Percentage is "+percentage);

		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./image/shoe.png");
		FileUtils.copyFile(source, target);
		
		driver.close();
		driver.quit();

	}

}
