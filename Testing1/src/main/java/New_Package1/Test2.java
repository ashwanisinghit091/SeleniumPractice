package New_Package1;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		// WebDriverManager.chromedriver().browserVersion("your_chrome_version").setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		
		Wait<WebDriver> wb = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		WebElement foo=wb.until(new Function<WebDriver,WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				
				if(driver.findElement(By.id("finish")).isDisplayed()) {
				return driver.findElement(By.id("finish"));}
				
				else {return null;}
				
			}
			
			
			
		});
		System.out.println(driver.findElement(By.id("finish")).isDisplayed());
	

	}

}
