package webDriverDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class EventFiringDriver_Demo {

	public static void main(String[] args) throws InterruptedException {
		// in this class we will create the EventFiringWebdriver to listen to all the events 
		
		WebDriver driver;
		String baseUrl = "https://learn.letskodeit.com";
		
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		  driver = new ChromeDriver();
		
		  EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		  Demo_WDEventListener el = new Demo_WDEventListener();
		  edriver.register(el);
		  
		  edriver.manage().window().maximize();
		  edriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  edriver.get(baseUrl);
//		  WebElement learnNow = edriver.findElement(By.xpath("//span [text() = 'Learn Now']"));
//		  learnNow.click();
		  
		  WebElement login = edriver.findElement(By.xpath("//a [@href = '/sign_in']"));
		  login.click();
		  
		  WebElement userName = edriver.findElement(By.xpath("//input[@id = 'user_email']"));
		  userName.sendKeys("test@email.com");
		  
		  WebElement password = edriver.findElement(By.xpath("//input[@id = 'user_password']"));
		  password.sendKeys("abcabc");
		  
		  WebElement login_Commit = edriver.findElement(By.name("commit"));
		  login_Commit.click();
		  
//		  WebElement msg = driver.findElement(By.xpath("//div[@class = 'alert alert-danger']"));
//		   String invalid_Msg = msg.getText();
		   
		   Thread.sleep(2000);
			  driver.quit();

	}

}
