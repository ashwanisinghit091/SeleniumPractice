package New_Package1;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment5 {
public static void main(String[] args) throws InterruptedException {
	
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	driver.get("http://qaclickacademy.com/practice.php");
	driver.findElement(By.id("checkBoxOption3")).click();
	String Text=driver.findElement(By.cssSelector("label[for='honda']")).getText().toLowerCase();
	
	Select es=new Select(driver.findElement(By.id("dropdown-class-example")));
	es.selectByValue(Text);

	driver.findElement(By.cssSelector("input[name='enter-name']")).click();
	driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(Text);
	driver.findElement(By.id("alertbtn")).click();
	String alertText=driver.switchTo().alert().getText().split(",")[0].trim().split(" ")[1];
	Assert.assertEquals(Text, alertText);
	
}
}
