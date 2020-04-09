package webDriverDemo;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoScreenShot {
	//Using Apache commons IO for taking the screen shots , we need to down load it from MVN repository 
	//and add the JAR files in the java build path 
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
		baseUrl = "https://www.goibibo.com/";
		driver.get(baseUrl);
		WebElement link = driver.findElement(By.linkText("Sign In"));
		link.click();
		
	}

	@After
	public void tearDown() throws Exception {
		String fileName = getFileName(10) + ".png";
		//"user.dir" will get the project directory where we are saving the other files 
		String directory = System.getProperty("user.dir") + "//ScreenShot//";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  	
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		driver.quit();
	}

	public String getFileName(int length){
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0 ; i < length ; i++ ){
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
}
