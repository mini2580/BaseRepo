package keyPressEvent;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CombinationofKeys {
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void testCombinationOfKeys() throws InterruptedException {
		driver.get(baseUrl);
		//sending a combination of keys to perform select all on the screen 
		String selectAll = Keys.CONTROL + "a";
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		Thread.sleep(3000);
	
	}
	
	@Test
	public void testCombinationOfKeysUsingChord() throws InterruptedException {
		driver.get(baseUrl);
		//Also we can another feature of keys i.e. chord in this we can give the combination on keys 
		
				String selectAll2 = Keys.chord(Keys.CONTROL, "a");
				driver.findElement(By.id("openwindow")).sendKeys(selectAll2);
				Thread.sleep(3000);
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
