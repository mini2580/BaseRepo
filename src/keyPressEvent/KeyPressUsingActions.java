package keyPressEvent;

import static org.junit.Assert.*;

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
import org.openqa.selenium.interactions.Actions;

public class KeyPressUsingActions {
	//when we are using Actions to send the keys there is no need to find an element
	//we can directly send the keys 
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
	public void testKeysUsingAction() throws InterruptedException {
		driver.get(baseUrl);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
		// Tried the below command to work but can not, got the IllegalArgument Exception 
		//Because the keydown and keyup can nly take the key instances
		//action.keyDown(Keys.CONTROL + "a").keyUp(Keys.CONTROL + "a").build().perform();
//		WebElement e1 = driver.findElement(By.id("name"));
//		action.doubleClick(e1).perform();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


}
