package New_Package1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
	static int obtainedSum = 0;
	static int expectedSum = 296;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		for (int i = 0; i < driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)"))
				.size(); i++) {
			obtainedSum = obtainedSum + Integer.parseInt(
					driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)")).get(i).getText());
			
		

		}
		
		Assert.assertEquals(obtainedSum, expectedSum);
	}

}
