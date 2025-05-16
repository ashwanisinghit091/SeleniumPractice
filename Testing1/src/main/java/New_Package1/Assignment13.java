package New_Package1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment13 {
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Rice");
		List<WebElement> veggieList=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> newVeggieList=veggieList.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(veggieList.get(0), newVeggieList.get(0));
		
		
	}

}
