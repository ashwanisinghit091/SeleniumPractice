package New_Package1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment9 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.firefoxdriver().setup();
		
		
		
		
		
		ChromeOptions op=new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		Proxy p=new Proxy();
		p.setHttpProxy("ip:");
		
		op.setCapability("proxy",p);
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("");
		driver.manage().deleteCookieNamed("sessionkey");
		

		EdgeOptions op1=new EdgeOptions();
		op1.setAcceptInsecureCerts(true);
		
		FirefoxOptions op2=new FirefoxOptions();
		op2.setAcceptInsecureCerts(true);
		
		
		driver.get("http://expired.badssl.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E://Screenshot1.jpg"));
			
		

	}

}
