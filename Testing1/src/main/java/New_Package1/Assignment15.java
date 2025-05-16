package New_Package1;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment15 {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> window_handles = driver.getWindowHandles();

		Iterator<String> it = window_handles.iterator();

		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);

		driver.get("https://rahulshettyacademy.com");

		String text = driver.findElement(By.cssSelector(
				"  div[class='courses-block col-lg-3 col-md-4 col-sm-6 col-xs-12']:nth-child(1) div div div"
						+ "  a[href*='https://courses.rahulshettyacademy.com/p']"))
				.getText();

		driver.switchTo().window(parent);
		driver.findElement(By.cssSelector("input[name='name']:nth-child(2)")).sendKeys(text);

		WebElement e = driver.findElement(By.cssSelector("input[name='name']:nth-child(2)"));
		File f=e.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("E://Screenshot2.jpg"));
		System.out.println(e.getRect().getDimension().getHeight());
		System.out.println(e.getRect().getDimension().getWidth());
	}
}
