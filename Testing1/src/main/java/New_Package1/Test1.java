package New_Package1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	static String[] vegName1 = { "Cucumber", "Brocolli" };

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		// WebDriverManager.chromedriver().browserVersion("your_chrome_version").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		List vegName_1 = Arrays.asList(vegName1);

		List<WebElement> e1 = driver.findElements(By.cssSelector("h4[class=product-name"));
		for (int i = 0; i < e1.size(); i++) {

			String [] vegName = e1.get(i).getText().split("-");
	

			if (vegName_1.contains(vegName[0].trim())) {

				// button[text()='ADD TO CART']
				
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				
			
				
			}

		}	driver.findElement(By.cssSelector("img[alt='Cart']")).click();
driver.findElement(By.xpath("//div/button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

driver.findElement(By.xpath("//input[@class='promoCode']")).click();
driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("aalo");

driver.findElement(By.cssSelector("button[class='promoBtn']")).click();

	}

}
