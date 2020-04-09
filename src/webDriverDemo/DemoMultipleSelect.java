package webDriverDemo;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoMultipleSelect {

	WebDriver driver;
	String baseUrl;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@Test
	public void testMultipleSelect() throws InterruptedException {
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.get(baseUrl);
		WebElement dd = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(dd);
		
		System.out.println("Element selected by value");
		sel.selectByValue("orange");
		Thread.sleep(3000);
		System.out.println("Element selected by index");
		sel.selectByIndex(0);
		Thread.sleep(3000);
		System.out.println("Element deslected by index");
		sel.deselectByIndex(0);
		Thread.sleep(3000);
		System.out.println("Element slelcted by visible text");
		sel.selectByVisibleText("Peach");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
