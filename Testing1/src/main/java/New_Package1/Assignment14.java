package New_Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment14 {

	
	
	public static void main(String[] args) {
		
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
	WebElement nameEditBox=	driver.findElement(By.cssSelector("input[name='name']:nth-child(2)"));
	
		System.out.println(	driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		WebElement exampleInputPassword1=	driver.findElement(By.cssSelector("label[for='exampleInputPassword1']"));
		//driver.findElement(with(By.tagName("input")).below(exampleInputPassword1)).click();
		//driver.findElement(with(By.tagName("input")).below(exampleInputPassword1)).sendKeys("did it");
		WebElement checkbox=	driver.findElement(By.xpath("//div[4]/label[@class='form-check-label']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();
		
		WebElement radio=	driver.findElement(By.xpath("//label[@for='exampleFormControlRadio1']"));
		
		System.out.println(
				driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
	
	}
	
	
	
	
}
