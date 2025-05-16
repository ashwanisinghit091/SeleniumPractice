package New_Package1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	driver.get("https://rahulshettyacademy.com/loginpagePractise");
	Actions a=new Actions(driver);
	a.moveToElement(driver.findElement(By.cssSelector("[class='blinkingText']"))).keyDown(Keys.CONTROL).click().build().perform();
	
	Set<String> windows=driver.getWindowHandles();
	Iterator<String> it=windows.iterator();
	String parentChild=it.next();
	String childWindow=it.next();
	
	driver.switchTo().window(childWindow);
	String emailId=driver.findElement(By.cssSelector("\tdiv p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];

	System.out.println(emailId);
	
	driver.switchTo().window(parentChild);
	
	
	

	

	}

}
