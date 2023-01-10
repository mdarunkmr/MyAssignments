package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonAssignment4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);

		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(price);

		String ratings = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println(ratings);

		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listOfHandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfHandles.get(1));

		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./image/product.png");
		FileUtils.copyFile(source, target);
		
		driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
		Thread.sleep(3000);
		String cartPrice = driver.findElement(By.xpath("//*[@id='attach-accessory-cart-subtotal']")).getText().replaceAll("₹", "");
		String subTotal = cartPrice.replaceAll(".00", "");
		System.out.println(subTotal);

		if (price.equals(subTotal)) {
			System.out.println("Prices are same");
		} else {
			System.out.println("Prices are not same");

		}
		driver.quit();

	}

}
