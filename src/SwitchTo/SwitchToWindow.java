package SwitchTo;




import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToWindow {
// This program demonstrates how to switch from one window to another
	// because selenium does not recognize the elements on the other open windows unless 
	//it does not get window handle of the new open window
	//window handle - it is a unique id of each window 
	
	// !!!Always remember the steps followed will be :
	// 1. get the parent handle 
	//2. Switch to new window handle 
	//3. back to parent handle to access the elements on that web page 
	WebDriver driver;
	String baseUrl ; 
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}


	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		String parentHandle = driver.getWindowHandle();
		System.out.println("The parent handle is :" + parentHandle);
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(2000);
		Set <String> handles = driver.getWindowHandles();
		
		for (String handle: handles){
			System.out.println("Handle is :" + handle);
			if (!handle.equals(parentHandle)){
				driver.switchTo().window(handle);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("java");
				Thread.sleep(3000);
				driver.close();
				break;
			}
		}
		
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("test done");
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
