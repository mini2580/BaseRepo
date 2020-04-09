package ActionsMethods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		baseUrl = "https://jqueryui.com/slider/";
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void testMouseHover() throws InterruptedException {
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.xpath("//div[@id = 'slider']/span"));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.dragAndDropBy(e1, 240, 0).build().perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
