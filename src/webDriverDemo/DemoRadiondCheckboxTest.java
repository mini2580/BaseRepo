package webDriverDemo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoRadiondCheckboxTest {

	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
	}

	
	@Test
	public void test() throws InterruptedException {
		baseUrl = "https://www.expedia.com/";
		driver.get(baseUrl);
		driver.findElement(By.cssSelector("button#tab-flight-tab-hp")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-type-roundtrip-hp-flight")));
		boolean isSelected = e1.isSelected();	
		System.out.println("Element Selected :" + isSelected);
		if (isSelected)
		{
//			WebElement e2 = driver.findElement(By.xpath("//input[@id = 'flight-type-one-way-hp-flight']"));
			js.executeScript("arguments[0].click();", e1);
			Thread.sleep(3000);
		System.out.println("I am clicked");
		}		
//		Thread.sleep(3000);
//		
//		//System.out.println("Element e1 is selected:" + e1.isSelected());
//		
		WebElement e2 = driver.findElement(By.xpath("//input[@id = 'flight-type-one-way-hp-flight']"));
		js.executeScript("arguments[0].click();", e2);
				
		Thread.sleep(3000);
		System.out.println("Element2 is clicked");
//		System.out.println("Element e2 is selected:" + e2.isSelected());
//		
		driver.findElement(By.xpath("//a[@id = 'flight-advanced-options-hp-flight']")).click();
		WebElement e3  = driver.findElement(By.xpath("//input[@id = 'advanced-flight-nonstop-hp-flight']"));
		js.executeScript("arguments[0].click();", e3);
		
//		System.out.println("Element e3 is selected:" + e3.isSelected());
//		
		Thread.sleep(3000);
		WebElement e4 = driver.findElement(By.xpath("//input[@id = 'advanced-flight-refundable-hp-flight']"));
		js.executeScript("arguments[0].click();", e4);
//		System.out.println("Element e4 is selected:" + e4.isSelected());
//		
	}
	
	
	@After
	public void tearDown() throws Exception {
	//	String fileName = getFileName(10) + "png";
		String directory = System.getProperty("user.dir") + "//screenshot"; 
		Thread.sleep(3000);
		driver.quit();
	}

}
