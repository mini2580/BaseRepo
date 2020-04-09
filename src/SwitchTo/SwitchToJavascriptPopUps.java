package SwitchTo;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToJavascriptPopUps {
	//JavaScript popups are nothing but the functions called from javascript langauage
	// you can find these functions in the DOM under the <script> tag
	//This establishes the fact that the buttons or the tag is using a javascript pop up 
	
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
	public void testAlert() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.id("name")).sendKeys("Mini");
		Thread.sleep(3000);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
			
	}
	
	@Test
	public void testConfirm() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.id("name")).sendKeys("Mini");
		Thread.sleep(3000);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(6000);
		
		
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
