package webDriverDemo;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAriaActiveDescedantAttribute {

	WebDriver driver ;
	String baseUrl ;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		baseUrl = "https://www.southwest.com/";
		driver.get(baseUrl);
		String partialText = "lon";
		String textToSelect = "";
		WebElement element = driver.findElement(By.id("gosuggest_inputSrc"));
		element.sendKeys(partialText);
		
		WebElement ulElement = driver.findElement(By.id("react-autosuggest-1"));
		String innerHtml = ulElement.getAttribute("innerHTML");
		System.out.println(innerHtml);
		
		List <WebElement> liElement = ulElement.findElements(By.tagName("li"));
		
		for (WebElement li : liElement ){
			//System.out.println("List of all elements" + li.getText());
			if (li.getText().contains(textToSelect))
			{
				li.click();
				break;
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
