package webDriverDemo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitDemo {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This will run before class");
	}

	WebDriver driver;
	String baseUrl;
	@Before
	public void setUp() throws Exception {
		//This will run before every test case
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		baseUrl = "https://learn.letskodeit.com/";
		driver.get(baseUrl);
		String title = driver.getTitle();
		System.out.println("The title of site is: " + title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("the current URL is :" + currentUrl);
		
		driver.findElement(By.xpath("//a[@href = '/sign_in']")).click();
		
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		
		driver.navigate().back();
		System.out.println("backed to homepage");
		Thread.sleep(3000);
		driver.navigate().forward();
		System.out.println("Navigate to login page");
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("The page is refreshed");
		Thread.sleep(3000);
		
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		//I will get executed after each test method
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("I will get executed after class");
	}


}
