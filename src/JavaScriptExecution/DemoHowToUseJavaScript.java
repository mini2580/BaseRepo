package JavaScriptExecution;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoHowToUseJavaScript {
	WebDriver driver;
	String baseUrl ;
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver() ;
		baseUrl = "https://learn.letskodeit.com/pages/practice";
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

	

	@Test
	public void test() throws InterruptedException {
		//open the browser using javascript 
		driver.get(baseUrl);
		//js.executeScript("Window.location = 'https://www.goibibo.com/'; ");
		// find an element using javascript
		WebElement e1 = (WebElement) js.executeScript("return document.getElementById('name');");
		e1.sendKeys("testing123");
		
		// finding the window size using javascript command 
		
		long height = (long) js.executeScript("return window.innerHeight;");
		long width = (long) js.executeScript("return window.innerWidth;");
		System.out.println("The Height of window is " + height + "pixels");
		System.out.println("The width of window is " + width + "pixels");
		
		// scrolling the window to get the element in view using javascript
		// below statement will scroll down the window
		js.executeScript("window.scrollBy(0,1400);");
		Thread.sleep(2000);
			
		// scroll up 
		js.executeScript("window.scrollBy(0,-1400);");
		Thread.sleep(2000);
		// scroll the element into the view 
		WebElement e2 = (WebElement) (js.executeScript("return document.getElementById('mousehover');"));
		js.executeScript("arguments[0].scrollIntoView(true);", e2);
		js.executeScript("window.scrollBy(0,-140);");
		Thread.sleep(2000);
	}
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
