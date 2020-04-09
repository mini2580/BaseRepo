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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoGenericMethods {
	WebDriver driver;
	String baseUrl ;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	

	@Test
	public void testGenericWebElement() {
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.get(baseUrl);
		WebElement element ; 
		GenericMethods gm = new GenericMethods(driver);
		element = gm.getElement("name", "id");
		element.sendKeys("test");
	}
	
	@Test
	public void testGenericWebElementList() throws InterruptedException {
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.get(baseUrl);
		List <WebElement> elementList ; 
		GenericMethods gm = new GenericMethods(driver);
		boolean isElementPresent = gm.isElementPresent("//input[@type = 'radio' and @name = 'cars']", "xpath");
		if (isElementPresent)
		{
			System.out.println("Element found");
			elementList = gm.getElementList("//input[@type = 'radio' and @name = 'cars']", "xpath");
			int size = elementList.size();
			for (int i = 0 ; i < size ; i++)
			{
				elementList.get(i).click();
				Thread.sleep(3000);
		}
		}
		else
		{
			System.out.println("Element Not found");
		}
		
		}
	@Test
	public void testGenericWaitMethod(){
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.get(baseUrl);
		WebElement element ; 
		GenericMethods gm = new GenericMethods(driver);
		element = gm.waitForanElement(By.id("name"), 3);
		element.sendKeys("test");
//		WebDriverWait wait = new WebDriverWait (driver, 3);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
