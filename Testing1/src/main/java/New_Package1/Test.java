package New_Package1;

import io.github.bonigarcia.wdm.WebDriverManager;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;



public class Test {

	public static void main(String[] args) {
		
		

		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().browserVersion("your_chrome_version").setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("Ashwani");
		driver.findElement(By.cssSelector("input[value='Alert']")).click();
		
		if(driver.switchTo().alert().getText().contains("Ashwani")) {
			Assert.assertTrue(true);
			driver.switchTo().alert().accept();
			
		}
		else {
			Assert.assertTrue(false);
			
		}
		
		
		
		//driver.close();
		
		
	}
}
