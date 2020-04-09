package SwitchTo;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToiFrames {
	//iFrame - it is an embedded page with in a web page 
	//again selenium does not recognize unless we switch to iFrame 
	// we can switch to the iframe using id , name , or number 
	// in case id or name is not present in the iframe then we have to hit and try with number
	//starting with index 0 
	
	WebDriver driver;
	String baseUrl ; 
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		baseUrl = "https://learn.letskodeit.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}


	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		//scroll down to the iframe using javascriptexecutor
		js.executeScript("window.scrollBy(0,1400);");
		//switch to iframe by id 
		driver.switchTo().frame("courses-iframe");
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("java");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		js.executeScript("window.scrollBy(0,-1100);");
		driver.findElement(By.id("name")).sendKeys("test done");
		
		
	}
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
