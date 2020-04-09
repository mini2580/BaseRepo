package webDriverDemo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoListOfWebElement {
	
	WebDriver driver;
	String baseUrl;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}	

	@Test
	public void test() throws InterruptedException {
		boolean isChecked = false;
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.get(baseUrl);
		List<WebElement> list = driver.findElements(By.xpath("//input[@type = 'radio' and @name = 'cars']"));
		int size = list.size();
		
		for (int i = 0 ; i < size ; i ++){
			isChecked = list.get(i).isSelected();
			
			if(!isChecked){
				list.get(i).click();
				Thread.sleep(3000);
			}
		}
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
