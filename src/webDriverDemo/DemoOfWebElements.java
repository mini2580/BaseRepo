package webDriverDemo;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoOfWebElements {

	public static void main(String[] args) throws InterruptedException {
		// practice site "https://letskodeit.teachable.com
		
		// This program is going to demo all the ways how we can find the 
		//WebElements i.e. By : id, name , classname, tagname , Xpath, linktext,
		//partiallinktext , CSS etc ...
		
		// calling the Webdriver first
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://login.yahoo.com/";
		driver.get(baseUrl);
		// command to maximize the window
		driver.manage().window().maximize();
		// This command is used to handle browser synchronization issues
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// finding an element By ID
		//driver.findElement(By.id("login-username")).sendKeys("mca2580");
		
		// finding element by Xpath
		
		//driver.findElement(By.xpath("//input[@id = 'login-username']")).sendKeys("mca2580");;
		
		// finding element by CSS selector
		
		driver.findElement(By.cssSelector("input#login-username.phone-no")).sendKeys("maya2580");
		
		driver.findElement(By.id("login-signin")).click();
		//finding element by name
		
		driver.findElement(By.name("password")).sendKeys("Dhruv2010");
		driver.findElement(By.xpath("//button[@id = 'login-signin']")).click();
	
		
		
		Thread.sleep(3000);
		driver.quit();
		Scanner scanChoice = new Scanner(System.in); 
		System.out.println("Enter the choice 1 or 2 :");
		int choice = scanChoice.nextInt();
	    scanChoice.close();
		if (choice == 1){
			cssWildCardDemo();
		}
		else{
			findingChildNodes();
		}
		

}
	public static void cssWildCardDemo() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://letskodeit.teachable.com";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.getTitle();
		driver.findElement(By.linkText("Practice")).click();
		
		driver.findElement(By.cssSelector("input[class *= 'displayed-class']")).sendKeys("Showup please");;
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	
	public static void findingChildNodes() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.makemytrip.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("li>div.makeFlex.column.flexOne.font10.whiteText")).click();
		//li>div.makeFlex.column.flexOne.font10.whiteText
		
		Thread.sleep(3000);
		driver.quit();
	}
}

