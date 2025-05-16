package New_Package1;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment10 {
	
	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {

		SoftAssert s=new SoftAssert();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// SoftAssert a =new SoftAssert();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	WebElement web=driver.findElement(By.id("gf-BIG"));
	for(int i=0;i<web.findElements(By.tagName("a")).size();i++) {
		
		String url=web.findElements(By.cssSelector("[class='gf-li'] a")).get(i).getDomAttribute("href");
		System.out.println(url);
		if(!url.equals("#")) {
		URI uri = new URI(url);
		URL url1 = uri.toURL();
		HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
		
		conn.setRequestMethod("HEAD");
		conn.connect();
		int  response =conn.getResponseCode();
		System.out.println(response);
		String name=web.findElements(By.cssSelector("[class='gf-li'] a")).get(i).getText();

		s.assertTrue(response<400, "Link is is failed for "+name);
		
		}
		
	
		
	}
	s.assertAll();
	}
}
