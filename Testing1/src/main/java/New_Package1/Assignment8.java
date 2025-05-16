package New_Package1;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		
	
		
		System.out.println(driver.findElements(By.cssSelector("fieldset table[id='product']:nth-child(2) tr")).size());
	
		System.out.println(driver.findElements(By.cssSelector("fieldset table[id='product']:nth-child(2) tr:nth-child(3) td")).size());
		for(int i=0;i<driver.findElements(By.cssSelector("fieldset table[id='product']:nth-child(2) tr:nth-child(3) td")).size();i++) {
		System.out.println(driver.findElements(By.cssSelector("fieldset table[id='product']:nth-child(2) tr:nth-child(3) td")).get(i).getText());}
		

	}

	

}
