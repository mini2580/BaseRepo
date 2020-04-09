package webDriverDemo;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoWaysToFindElementsUsingXpath {

	public static void main(String[] args) throws InterruptedException {
		//In this Demo class we will see different ways/functions to find elements 
		//using xpath.
		//Absolute xpath Vs. Relative xpath
		//Absolute xpath - uses '/' to find the immediate child which gives us a 
		//very specific xpath and in future if anything changes in the script, it breaks easily
	    //Absolute xpath: html//div[@id = 'primary-navigation']/div/div/ul/li[3]/div/button"
		//Relative xpath://div[@id = 'primary-navigation']//button[text() = 'LOGIN']
		//In case of absolute Xpath if there will be another button added just after div or anyother child 
		//its going to find that button instead of the one we intend and the xpath will break 
		//however, the relative xpath is very generic and goes and looks of a button with LOGIN 
		
		//example:
		
		
		
//		Scanner scanChoice = new Scanner(System.in);
//		System.out.println("Enter 1 to use Absolute xpath and 2 for Relative ");
//		int choice = scanChoice.nextInt();
//		scanChoice.close();
//		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		Actions act = new Actions(driver);
//		String baseUrl = "https://aib.ie/";
//		driver.get(baseUrl);
//		driver.manage().window().fullscreen();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		if (choice == 1){
//		WebElement parent = driver.findElement(By.xpath("html//div[@id = 'primary-navigation']/div/div/ul/li[3]/div/button"));
//		act.moveToElement(parent).build().perform();
//		Thread.sleep(3000);
//		driver.quit();
//		}
//		else 
//		{
//			driver.findElement(By.xpath("//div[@id = 'primary-navigation']//button[text() = 'LOGIN']")).click();
//			driver.quit();
//		}
// Find an element using Text() 
// Syntax: //div[text() = 'LOGIN']
		
// Find an  element using Contains:
// Syntax: //div[contains(text(), 'value']
		// //div[contains(@id, 'value']
		
		// Find an element using starts-with
		//syntax: //div[starts-with[attribute, 'value']
		
		// find elements using parent, preceeding-sibling,following-sibling
		//DemoParentChildWay();
		useOfSiblingmethod();
		}
	
	public static void DemoParentChildWay() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	String baseUrl ="https://learn.letskodeit.com/p/practice";
	driver.get(baseUrl);
	driver.manage().window().fullscreen();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	String price = driver.findElement(By.xpath("//table[@id = 'product']//td[text() = 'Python Programming Language']/following-sibling::td")).getText();
	
	Thread.sleep(3000);
	driver.quit();
	System.out.println("The price of Python programming course is : " + price);
}
	
	public static void useOfSiblingmethod() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mini\\Documents\\Testing\\mylib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://dhtmlx.com/docs/products/dhtmlxGrid/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait =  new WebDriverWait( driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@dhx_id='u1581853545147']//div[@title='ERP']/following-sibling::div[2]/div[@class = 'dhx_cell-content']")));
//		String titlename = ele.getText();
//		System.out.println("The title name is :" + titlename);
	    Thread.sleep(3000);
	    driver.quit();
		
	}
	
}