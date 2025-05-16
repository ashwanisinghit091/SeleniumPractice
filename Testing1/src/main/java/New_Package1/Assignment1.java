package New_Package1;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		



		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("credentials_enable_service", false);

		prefs.put("password_manager_enabled", false);

		Map<String, Object> profile = new HashMap<String, Object>();

		profile.put("password_manager_leak_detection", false);

		prefs.put("profile", profile);

		options.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();

		// WebDriverManager.chromedriver().browserVersion("your_chrome_version").setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("#password")).sendKeys("learning");
		driver.findElement(By.cssSelector(" label:nth-child(2) span[class='checkmark']")).click();
		Thread.sleep(3000);
		// driver.switchTo().alert().accept();
		driver.findElement(By.cssSelector(".btn.btn-success")).click();

		Select s = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		s.selectByValue("consult");

		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();
		Thread.sleep(3000);

		List<WebElement> web = driver.findElements(By.cssSelector(".btn.btn-info"));

		for (WebElement w : web) {
			w.click();
		}
	

		//WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".nav-link.btn.btn-primary"))));
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

	}
}
