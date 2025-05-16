package New_Package1;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment12 {
	static	List<String> price ;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		List<WebElement> list1 = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> unsortedList = list1.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = unsortedList.stream().sorted().collect(Collectors.toList());

		Assert.assertEquals(unsortedList, sortedList);
	
do { 	List<WebElement> list2 = driver.findElements(By.xpath("//tr/td[1]"));
		price = list2.stream().filter(s -> s.getText().contains("Orange")).map(s -> getveggie(s))
				.collect(Collectors.toList());
		if(price.size()< 1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		price.stream().forEach(s->System.out.println(s));
}
		while (price.size()< 1) ;
			
	

	}

	private static String getveggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();

	}

}
