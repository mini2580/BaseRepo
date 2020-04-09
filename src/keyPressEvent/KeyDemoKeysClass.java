package keyPressEvent;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyDemoKeysClass {
	//Another way to access your application is through keys, like filing of text boxex using TAB 
	//Key and to hit a button , simply press enter 
	//In this code we will achieve the keypress events using the KEYS package of selenium
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		baseUrl = "https://learn.letskodeit.com";
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void testKeyPress() throws InterruptedException {
		driver.get(baseUrl);

		driver.findElement(By.xpath("//a[@href = '/sign_in']")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("user_email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		driver.findElement(By.id("user_password")).sendKeys("dhruv2010");
		driver.findElement(By.id("user_password")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


}
