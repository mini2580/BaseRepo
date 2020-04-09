package webDriverDemo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoDropDownElement {
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
	public void test() throws InterruptedException {
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.get(baseUrl);
		WebElement dd = driver.findElement(By.id("carselect"));
		Select sel = new Select(dd);
		
		System.out.println("Element selected by value");
		sel.selectByValue("bmw");
		Thread.sleep(3000);
		System.out.println("Element selected by index");
		sel.selectByIndex(1);
		Thread.sleep(3000);
//		System.out.println("Element deslected by index");
//		sel.deselectByIndex(1);
//		Thread.sleep(3000);
		System.out.println("Element slelcted by visible text");
		sel.selectByVisibleText("Honda");
	}
	
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000);
		driver.quit();
	}


}
