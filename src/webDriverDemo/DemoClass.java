package webDriverDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		
		//Instead of setting the property everytime , we can define the path f chrome driver
		// in system variables under environment variables and restart the computer to get 
		// the path in effect 
		
		WebDriver driver = new ChromeDriver();
	//	WebElement we1 = new WebElement();
        String baseUrl = "https://www.amazon.in/";
        driver.get(baseUrl);
	}

}
