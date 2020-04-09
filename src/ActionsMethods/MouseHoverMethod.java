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

public class MouseHoverMethod {
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		baseUrl = "https://learn.letskodeit.com/pages/practice";
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@Test
	public void testMouseHover() throws InterruptedException {
		driver.get(baseUrl);
		js.executeScript("window.scrollBy(0,600);");
		Thread.sleep(3000);
		WebElement mouseBtn = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseBtn).perform();
		Thread.sleep(3000);
		WebElement selectElement = driver.findElement(By.xpath("//div[@class = 'mouse-hover-content']/a[text() = 'Top']"));
		selectElement.click();
		Thread.sleep(3000);
		
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
