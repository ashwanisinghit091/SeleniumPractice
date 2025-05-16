package New_Package1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");

		WebElement subdriver = driver.findElement(By.id("gf-BIG"));

		System.out.println(subdriver.findElements(By.tagName("a")).size());
		

		WebElement subdriver1= subdriver.findElement(By.xpath("//td[1]/ul"));
	 System.out.println(subdriver1.findElements(By.tagName("li")).size());
	 
	List<WebElement> links=subdriver1.findElements(By.tagName("a"));
	 for(WebElement link: links) {
		 
		Actions a=new Actions(driver);
		a.moveToElement(link).keyDown(Keys.CONTROL).click().build().perform();
		
		
	 }
	 
	 Set<String> s=driver.getWindowHandles();
	Iterator<String> it= s.iterator();
	 while(it.hasNext()) {
		 
		driver.switchTo().window(it.next());
		
		System.out.println(driver.getTitle());
		 
	 }

	}

}
