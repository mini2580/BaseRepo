package ActionsMethods;



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

public class DragandDropMethod {
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		baseUrl = "https://jqueryui.com/droppable/";
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
		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		//Two ways to drag and drop the element 
		//action.dragAndDrop(dragElement, dropElement).build().perform();
		action.clickAndHold(dragElement).moveToElement(dropElement).release().perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
