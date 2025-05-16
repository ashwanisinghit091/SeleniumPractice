package New_Package1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
	
	static String day="12";
	static String month="10";
	static String year="2026";
	
	static String [] expectedList= {month,day,year};
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	driver.findElement(By.className("react-date-picker__inputGroup")).click();
	
	driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
	
	driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
	driver.findElement(By.xpath("//button[text()="+year+"]")).click();
	driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
	driver.findElement(By.xpath("//button/abbr[text()="+day+"]")).click();
	List<WebElement> web=driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));
	for(int i=0;i<driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input")).size();i++) {
	
      String value= web.get(i).getDomAttribute("value");
      
	Assert.assertEquals(expectedList[i], value);
	
		
	}
	
	}

}
