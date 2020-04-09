package webDriverDemo;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoDatePicker {
	WebDriver driver ;
	String baseUrl ; 
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
	}
 

	@Test
	public void test() throws InterruptedException {
		baseUrl = "https://www.southwest.com/";
		driver.get(baseUrl);
		WebElement departureElement = driver.findElement(By.id("LandingAirBookingSearchForm_departureDate"));
		departureElement.click();
		Thread.sleep(3000);
		WebElement dateElement = driver.findElement(By.xpath("//div[@class = 'calendar-month']//div[@class = 'calendar-month--days']"));
		WebElement date = dateElement.findElement(By.id("calendar-112-2020-02-23"));
		date.click();
		Thread.sleep(3000);
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
