package webDriverDemo;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTimeScenarioForDatePicker {
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
		 WebElement ele = driver.findElement(By.xpath("//div[@class = 'calendar-month']//div[@class = 'calendar-month--days']"));
		 List <WebElement> dateList = ele.findElements(By.tagName("button"));
		 int calendarSize = dateList.size();
		System.out.println("the size of datelist is :" + calendarSize);
		List <WebElement> validDate = null ;
		int count = 0;
		for (int i = 0 ; i < calendarSize ; i++){
			System.out.println("The element " + i + "is :" + dateList.get(i).isEnabled() );
			if (dateList.get(i).isEnabled()){
				System.out.println("Element added to new list");
				
				validDate.add(count , dateList.get(i));
				count = count + 1;
			}
		}
		
		int  validSize = validDate.size();
		System.out.println("The size of valid date is :" + validSize );
		for (int i = 0 ; i < validSize ; i++)
		{
			System.out.println(" The valid dates are :" + validDate.get(i));
		}
	}
	
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
