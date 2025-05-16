package New_Package1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com");
		List<WebElement> elink = driver.findElements(By.tagName("a"));

		for (WebElement link : elink) {

			if (link.getText().equals("Multiple Windows")) {

				link.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		String parentWindow= it.next();
		String childWindow= it.next();
		
		driver.switchTo().window(childWindow);
		
		String childWindowText=driver.findElement(By.xpath("//div/h3")).getText();
		
		driver.switchTo().window(parentWindow);
		String parentWindowText=driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		System.out.println(parentWindowText);
		System.out.println(childWindowText);
		
		driver.navigate().back();
		
		
		for (WebElement link : elink) {

			if (link.getText().equals("Nested Frames")) {

				link.click();
				break;
			}
		}
		
		
		WebDriver we =(WebDriver) driver.switchTo().frame(0);
		we.switchTo().frame(1);
		System.out.println(driver.findElement(By.xpath("//div[contains(@id,'content')]")).getText());
     
	}

}
